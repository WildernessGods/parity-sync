package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.service.TransactionsService;
import com.parity.paritysync.utils.ParityLog;
import com.parity.paritysync.utils.ReturnMessage;
import com.parity.paritysync.utils.parity.ParityUpdateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.parity.paritysync.utils.ReturnMessage.OPERATE_SUCCESS;
import static java.util.stream.Collectors.toList;

@RestController
public class TransactionsController {

    private final TransactionsService transactionsService;

    private final ParityUpdateUtil parityUpdateUtil;

    public TransactionsController(TransactionsService transactionsService, ParityUpdateUtil parityUpdateUtil) {
        this.transactionsService = transactionsService;
        this.parityUpdateUtil = parityUpdateUtil;
    }

    @ParityLog("分页查询所有交易记录")
    @GetMapping("/transactions")
    public ReturnMessage readOpt1(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectAll(pageNum * 20);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);
        parityUpdateUtil.getBlockConfirmationsCount(pageInfo.getList());

        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", pageInfo);
    }

    @ParityLog("根据交易哈希查询交易记录")
    @GetMapping("/transactions/hash")
    public ReturnMessage readByHash(@RequestParam("hash") String hash) {
        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", transactionsService.selectByTxHash(hash));
    }

    @ParityLog("根据区块哈希查询交易记录")
    @GetMapping("/transactions/blockHash")
    public ReturnMessage readByBlockHash(@RequestParam("blockHash") String blockHash, @RequestParam("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByBlockHash(blockHash);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", pageInfo);
    }

    @ParityLog("根据区块号查询交易记录")
    @GetMapping("/transactions/blockNumber")
    public ReturnMessage readByBlockNumber(@RequestParam("blockNumber") Long blockNumber, @RequestParam("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByBlockNumber(blockNumber);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", pageInfo);
    }

    @ParityLog("根据地址查询交易记录")
    @GetMapping("/transactions/author")
    public ReturnMessage readByAuthorOpt(@RequestParam("author") String author, @RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByAuthor(author, pageNum * 20);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", pageInfo);
    }

    @ParityLog("分页查询合约内部交易")
    @GetMapping("/transactions/contract")
    public ReturnMessage readByContract(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 50);
        List<ReturnContractTransactions> returnTransactionsList = transactionsService.selectByCreatest(pageNum * 50);
        PageInfo<ReturnContractTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        Map<Long, List<ReturnContractTransactions>> returnTransactionsMapList =
                pageInfo.getList().stream().collect(Collectors.groupingBy(ReturnContractTransactions::getBlocknumber,
                        () -> new TreeMap<>(Comparator.reverseOrder()), toList()));

        return ReturnMessage.success(OPERATE_SUCCESS).add("transactions", returnTransactionsMapList).add("pages", pageInfo.getPages());
    }
}
