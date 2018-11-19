package com.parity.paritysync.utils.parity;

import com.parity.paritysync.bean.Author;
import com.parity.paritysync.bean.Block;
import com.parity.paritysync.bean.BlockUncle;
import com.parity.paritysync.bean.DailyTradingVolume;
import com.parity.paritysync.bean.Transactions;
import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.service.AuthorService;
import com.parity.paritysync.service.BlockService;
import com.parity.paritysync.service.BlockUncleService;
import com.parity.paritysync.service.DailyTradingVolumeService;
import com.parity.paritysync.service.ReceiptLogsService;
import com.parity.paritysync.service.TransactionReceiptService;
import com.parity.paritysync.service.TransactionsService;
import com.parity.paritysync.utils.Utils;
import com.parity.paritysync.utils.parity.result.ResultCommon;
import com.parity.paritysync.utils.parity.result.ResultGetBlock;
import com.parity.paritysync.utils.parity.result.ResultTransactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.averagingDouble;

@Service
public class ParityUpdateUtil {

    private Logger logger = LoggerFactory.getLogger(ParityUpdateUtil.class);

    private final AuthorService authorService;

    private final BlockService blockService;

    private final BlockUncleService blockUncleService;

    private final DailyTradingVolumeService dailyTradingVolumeService;

    private final TransactionsService transactionsService;

    private final TransactionReceiptService transactionReceiptService;

    private final ReceiptLogsService receiptLogsService;

    private final Utils utils;

    public ParityUpdateUtil(AuthorService authorService, BlockService blockService, BlockUncleService blockUncleService,
                            DailyTradingVolumeService dailyTradingVolumeService, TransactionsService transactionsService,
                            TransactionReceiptService transactionReceiptService, ReceiptLogsService receiptLogsService, Utils utils
    ) {

        this.authorService = authorService;
        this.blockService = blockService;
        this.blockUncleService = blockUncleService;
        this.dailyTradingVolumeService = dailyTradingVolumeService;
        this.transactionsService = transactionsService;
        this.transactionReceiptService = transactionReceiptService;
        this.receiptLogsService = receiptLogsService;
        this.utils = utils;
    }

    //    @Scheduled(cron = "30 * * * * ? *")
    public void parityRequest() {

        try {
            ResultCommon blockNumber = ParityRequest.eth_blockNumber();
            logger.info("blockNumber = " + blockNumber.getResult());
            if (blockService.selectByPrimaryKey(Long.valueOf(blockNumber.getResult().substring(2), 16)) == null) {

                ResultGetBlock resultGetBlock = ParityRequest.eth_getBlockByNumber(blockNumber.getResult());

                if (resultGetBlock.getResult() != null) {

                    blockService.insertSelective(new Block(resultGetBlock, utils));

                    insertUncles(resultGetBlock.getResult().getUncles(), resultGetBlock.getResult().getHash(),
                            Long.valueOf(resultGetBlock.getResult().getNumber().substring(2),
                                    16));
                    insertTransactions(resultGetBlock.getResult().getTransactions(), Long.valueOf(blockNumber.getResult().substring(2), 16),
                            resultGetBlock.getResult().getTimestamp(), resultGetBlock.getResult().getUncles().size());
                    insertParentBlock(resultGetBlock);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    //    @Scheduled(cron = "0 0 17 * * ? ")
    public void parityCheckLeak() {
        insertParity(0, 7000000);
    }

    /**
     * 每日交易统计
     */
    public void dailyTradingVolume() {

        LocalDate localDate = LocalDate.of(2015, 7, 30);

        IntStream.rangeClosed(0, 1000).forEach(i -> {

            LocalDate plusDays = localDate.plusDays(i);

            List<Block> blockList = blockService.selectByDate(plusDays.toString());

            if (blockList.size() > 0) {

                logger.info("blockList size = " + blockList.size() + " date = " + plusDays.toString());

                DailyTradingVolume dailyTradingVolume = new DailyTradingVolume(plusDays.toString(),
                        blockList.stream().mapToInt(Block::getTotaltransactionscount).sum());

                if (dailyTradingVolume.getCount() > 0) {
                    DailyTradingVolume selectByDate = dailyTradingVolumeService.selectByDate(plusDays.toString());
                    if (selectByDate == null) {
                        dailyTradingVolumeService.insertSelective(dailyTradingVolume);
                    } else {
                        dailyTradingVolume.setId(selectByDate.getId());
                        dailyTradingVolumeService.updateByPrimaryKeySelective(dailyTradingVolume);
                    }
                }
            }
        });
    }

    /**
     * 遍历区块号插入数据库
     *
     * @param start 起始区块号
     * @param end   截至区块号
     */
    public void insertParity(long start, long end) {

        LongStream.rangeClosed(start, end).boxed().forEach(i -> {
            try {
                ResultGetBlock resultGetBlock = ParityRequest.eth_getBlockByNumber("0x" + Long.toHexString(i));
                if (resultGetBlock.getResult() != null) {

                    Block block = blockService.selectByPrimaryKey(i);
                    if (block == null) {
                        logger.info("insert block number = " + i);
                        block = new Block(resultGetBlock, utils);
                        blockService.insertSelective(block);
                    }
                    insertTransactions(resultGetBlock.getResult().getTransactions(), i, block.getTimestamp(), block.getUnclecount());
                    insertUncles(resultGetBlock.getResult().getUncles(), block.getHash(), i);
                    insertAddress(resultGetBlock.getResult().getAuthor(), 0);
                } else {
                    logger.error("not found block number = " + i);
                }
            } catch (IOException e) {
                logger.error("insertParity " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    /**
     * 遍历区块号更新挖矿收益
     *
     * @param start 起始区块号
     * @param end   截至区块号
     */
    public void updateParity(long start, long end) {

        LongStream.rangeClosed(start, end).parallel().boxed().forEach(i -> {

//            try {
//                ResultGetBlock resultGetBlock = ParityRequest.eth_getBlockByNumber("0x" + Long.toHexString(i));
//                if (resultGetBlock.getResult() != null) {
//                    logger.info("update totaldifficulty block number = " + i);
//                    Block block = new Block();
//                    block.setNumber(i);
//                    block.setTotaldifficulty(utils.toString(resultGetBlock.getResult().getTotalDifficulty()));
//                    blockService.updateByPrimaryKeySelective(block);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            Block block = blockService.selectByPrimaryKey(i);
            if (block != null) {
                List<ReturnTransactions> returnTransactionsList = transactionsService.selectByBlockNumber(i);
                if (returnTransactionsList != null) {
                    logger.info("update blockReward block number = " + i);
                    blockService.updateByPrimaryKeySelective(new Block(i, returnTransactionsList.stream().mapToDouble(ReturnTransactions::getFee).sum(),
                            block.getUnclecount(),
                            returnTransactionsList.stream().collect(averagingDouble(ReturnTransactions::getGasprice)) * 1_000_000_000));
                }

//                List<BlockUncle> blockUncleList = blockUncleService.selectByUncleByHash(block.getHash());
//                if (blockUncleList != null && blockUncleList.size() > 0) {
//                    logger.info("update unclesReward block number = " + i);
//                    blockService.updateByPrimaryKeySelective(new Block(i, blockUncleList.stream().mapToDouble(u -> u.getSingleUncleReward(i)).sum()));
//                }
            }
        });
    }

    /**
     * 插入交易记录
     *
     * @param resultTransactionsList 交易列表
     */
    private void insertTransactions(List<ResultTransactions> resultTransactionsList, Long blockNumber, String timestamp, Integer unclecount) {

        if (resultTransactionsList != null) {

            List<TransactionsWithBLOBs> transactionsWithBLOBsList = resultTransactionsList.stream()
                    .filter(r -> transactionsService.selectByTxHash(r.getHash()) == null)
                    .map(t -> t.getTransactionsWithBLOBs(utils, timestamp))
                    .collect(Collectors.toList());

            if (transactionsWithBLOBsList.size() > 0) {

                List<Author> authorList = transactionsWithBLOBsList.stream().map(TransactionsWithBLOBs::getAuthor).distinct()
                        .filter(author -> authorService.selectByAddress(author.getAddress()) == null).collect(Collectors.toList());

                if (authorList.size() > 0) {
                    logger.info("insert author size = " + authorList.size());
                    authorService.batchInsertSelective(authorList);
                }

                logger.info("insert transactions size = " + transactionsWithBLOBsList.size());
                transactionsService.batchInsertSelective(transactionsWithBLOBsList);
            }

            blockService.updateByPrimaryKeySelective(new Block(blockNumber,
                    transactionsWithBLOBsList.stream().mapToDouble(Transactions::getFee).sum(),
                    unclecount,
                    transactionsWithBLOBsList.stream().collect(averagingDouble(TransactionsWithBLOBs::getGasprice)) * 1_000_000_000));
        }
    }

    /**
     * 遍历交易记录
     */
    private void traversingTransactions() {

        IntStream.rangeClosed(0, 40000).boxed().forEach(i -> {

            List<TransactionsWithBLOBs> transactionsWithBLOBsList = transactionsService.selectByPageNum(i * 100, 100);

            List<Author> authorList = transactionsWithBLOBsList.stream().map(TransactionsWithBLOBs::getAuthor).collect(Collectors.toList());

            if (authorList.size() > 0) {
                authorService.batchInsertSelective(authorList);
            }
        });
    }

    /**
     * 插入交易地址
     *
     * @param address 地址
     * @param type    类型 0：普通地址 1：合约地址
     */
    private void insertAddress(String address, Integer type) {
        if (authorService.selectByAddress(address) == null) {
            authorService.insertSelective(new Author(address, type));
        }
    }

    /**
     * 插入叔块
     *
     * @param uncles 叔块列表
     * @param hash   打包叔块的区块哈希
     */
    private void insertUncles(List<String> uncles, String hash, Long blockNumber) {

        if (uncles != null && uncles.size() > 0) {

            uncles.stream().filter(r -> blockUncleService.selectByPrimaryKey(r) == null).forEach(u -> {

                logger.info("uncle = " + u);

                try {
                    ResultGetBlock resultGetUncleBlock = ParityRequest.eth_getUncleByBlockHashAndIndex(hash, uncles.indexOf(u));

                    if (resultGetUncleBlock.getResult() != null) {
                        blockUncleService.insertSelective(new BlockUncle(resultGetUncleBlock, hash, utils));

                        List<BlockUncle> blockUncleList = blockUncleService.selectByUncleByHash(hash);
                        if (blockUncleList != null && blockUncleList.size() > 0) {
                            blockService.updateByPrimaryKeySelective(new Block(blockNumber,
                                    blockUncleList.stream().mapToDouble(blockUncle -> blockUncle.getSingleUncleReward(blockNumber)).sum()));
                        }
                    }
                } catch (IOException e) {
                    logger.error("insertUncles = " + e.getMessage());
                }
            });
        }
    }

    /**
     * 递归更新父块
     *
     * @param resultGetBlock
     * @throws IOException
     */
    private void insertParentBlock(ResultGetBlock resultGetBlock) throws IOException {

        ResultGetBlock resultGetParentBlock = ParityRequest.eth_getBlockByHash(resultGetBlock.getResult().getParentHash());

        if (resultGetParentBlock.getResult() != null) {

            Block block = blockService.selectByHash(resultGetBlock.getResult().getParentHash());
            if (block == null) {
                logger.info("ParentBlockNumber = " + resultGetParentBlock.getResult().getNumber());
                block = new Block(resultGetParentBlock, utils);
                blockService.insertSelective(block);
            }

            insertUncles(resultGetBlock.getResult().getUncles(), resultGetBlock.getResult().getHash(),
                    Long.valueOf(resultGetBlock.getResult().getNumber().substring(2), 16));
            insertTransactions(resultGetBlock.getResult().getTransactions(), block.getNumber(), block.getTimestamp(), block.getUnclecount());

            insertParentBlock(resultGetParentBlock);
        }
    }

    /**
     * 同步地址的交易总量
     */
    public void updateAuthor(Long maxId) {

        LongStream.rangeClosed(1, maxId).boxed().forEach(i -> {

            Author author = authorService.selectByPrimaryKey(i);

            if (author != null) {

                List<ReturnTransactions> returnTransactionsList = transactionsService.selectByAuthor(author.getAddress());

                logger.info("id = " + i);

                if (returnTransactionsList != null && returnTransactionsList.size() != author.getTransactionscount()) {
                    logger.info("id = " + i + " address = " + author.getAddress() + " size = " + returnTransactionsList.size() + " count = " + author.getTransactionscount());

                    author.setTransactionscount((long) returnTransactionsList.size());
                    authorService.updateSelectiveByAddress(author);
                }
            }
        });
    }

    /**
     * 获取交易的区块确认数
     *
     * @param list 交易列表
     */
    public void getBlockConfirmationsCount(List<ReturnTransactions> list) {

        list.forEach(t -> {
            try {
                ResultCommon eth_blockNumber = ParityRequest.eth_blockNumber();
                if (eth_blockNumber != null) {
                    t.setBlockConfirmationsCount(Long.valueOf(eth_blockNumber.getResult().substring(2), 16) - t.getBlocknumber());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}