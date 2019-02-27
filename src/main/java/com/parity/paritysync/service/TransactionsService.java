package com.parity.paritysync.service;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.dao.TransactionsMapper;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.returntype.ReturnTransactionsRelationShip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionsService {

    private Logger logger = LoggerFactory.getLogger(TransactionsService.class);

    private final TransactionsMapper transactionsMapper;

    public TransactionsService(TransactionsMapper transactionsMapper) {
        this.transactionsMapper = transactionsMapper;
    }

    public int insertSelective(TransactionsWithBLOBs transactions) {
        return transactionsMapper.insertSelective(transactions);
    }

    public int batchInsertSelective(List<TransactionsWithBLOBs> transactionsWithBLOBsList) {
        if (transactionsWithBLOBsList != null && transactionsWithBLOBsList.size() > 0) {
            logger.info("insert transactions size = " + transactionsWithBLOBsList.size());
            return transactionsMapper.batchInsertSelective(transactionsWithBLOBsList);
        }
        return 0;
    }

    public TransactionsWithBLOBs selectByPrimaryKey(Long id) {
        return transactionsMapper.selectByPrimaryKey(id);
    }

    public ReturnTransactions selectByTxHash(String hash) {
        return transactionsMapper.selectByTxHash(hash);
    }

    public List<ReturnTransactions> selectByBlockHash(String blockHash) {
        return transactionsMapper.selectByBlockHash(blockHash);
    }

    public List<ReturnTransactions> selectByBlockNumber(Long blockNumber) {
        return transactionsMapper.selectByBlockNumber(blockNumber);
    }

    public List<TransactionsWithBLOBs> selectByPageNum(Integer index, Integer pageSize) {
        return transactionsMapper.selectByPageNum(index, pageSize);
    }

    public List<ReturnTransactions> selectAll(Long index) {
        return transactionsMapper.selectAll(index);
    }

    public List<ReturnTransactions> selectByAuthor(String author, Long index) {
        return transactionsMapper.selectByAuthor(author, index);
    }

    public List<ReturnContractTransactions> selectByCreatest(Long index) {
        return transactionsMapper.selectByCreatest(index);
    }

    public long selectCountByAuthor(String address) {
        return transactionsMapper.selectCountByAuthor(address);
    }

    public List<ReturnTransactions> selectForSearchByAuthor(String address) {
        return transactionsMapper.selectForSearchByAuthor(address);
    }

    @Cacheable(value = "selectByAuthorToRelationShip", key = "#root.args")
    public List<ReturnTransactionsRelationShip> selectByAuthorToRelationShip(String address) {
        return transactionsMapper.selectByAuthorToRelationShip(address);
    }

    public List<ReturnTransactionsRelationShip> selectBlockFromByAddress(String address) {
        return transactionsMapper.selectBlockFromByAddress(address);
    }

    public List<ReturnTransactionsRelationShip> selectBlockToByAddress(String address) {
        return transactionsMapper.selectBlockToByAddress(address);
    }

}
