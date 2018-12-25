package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.returntype.ReturnTransactionsRelationShip;
import com.parity.paritysync.service.TransactionsService;
import com.parity.paritysync.utils.ParityLog;
import com.parity.paritysync.utils.parity.ParityUpdateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toList;

@RestController
public class TransactionsController {

    private final Logger logger = LoggerFactory.getLogger(TransactionsController.class);

    private final TransactionsService transactionsService;

    private final ParityUpdateUtil parityUpdateUtil;

    public TransactionsController(TransactionsService transactionsService, ParityUpdateUtil parityUpdateUtil) {
        this.transactionsService = transactionsService;
        this.parityUpdateUtil = parityUpdateUtil;
    }

    @ParityLog("分页查询所有交易记录")
    @GetMapping("/transactions")
    public ResponseEntity readOpt1(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectAll(pageNum * 20);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);
        parityUpdateUtil.getBlockConfirmationsCount(pageInfo.getList());

        return ResponseEntity.ok(pageInfo);
    }

    @ParityLog("根据交易哈希查询交易记录")
    @GetMapping("/transactions/hash")
    public ResponseEntity readByHash(@RequestParam("hash") String hash) {
        return ResponseEntity.ok(transactionsService.selectByTxHash(hash));
    }

    @ParityLog("根据区块哈希查询交易记录")
    @GetMapping("/transactions/blockHash")
    public ResponseEntity readByBlockHash(@RequestParam("blockHash") String blockHash, @RequestParam("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByBlockHash(blockHash);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ResponseEntity.ok(pageInfo);
    }

    @ParityLog("根据区块号查询交易记录")
    @GetMapping("/transactions/blockNumber")
    public ResponseEntity readByBlockNumber(@RequestParam("blockNumber") Long blockNumber, @RequestParam("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByBlockNumber(blockNumber);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ResponseEntity.ok(pageInfo);
    }

    @ParityLog("根据地址查询交易记录")
    @GetMapping("/transactions/author")
    public ResponseEntity readByAuthorOpt(@RequestParam("author") String author, @RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 20);
        List<ReturnTransactions> returnTransactionsList = transactionsService.selectByAuthor(author, pageNum * 20);
        PageInfo<ReturnTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        return ResponseEntity.ok(pageInfo);
    }

    @ParityLog("分页查询合约内部交易")
    @GetMapping("/transactions/contract")
    public ResponseEntity readByContract(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 50);
        List<ReturnContractTransactions> returnTransactionsList = transactionsService.selectByCreatest(pageNum * 50);
        PageInfo<ReturnContractTransactions> pageInfo = new PageInfo<>(returnTransactionsList);

        Map<Long, List<ReturnContractTransactions>> returnTransactionsMapList =
                pageInfo.getList().stream().collect(Collectors.groupingBy(ReturnContractTransactions::getBlocknumber,
                        () -> new TreeMap<>(Comparator.reverseOrder()), toList()));

        return ResponseEntity.ok(returnTransactionsMapList);
    }

    @ParityLog("查询地址间的交易关系")
    @GetMapping("/transactions/relationship")
    public ResponseEntity readRelationShip(@RequestParam("author") String author) {

        List<ReturnTransactionsRelationShip> relationShipList = transactionsService.selectByAuthorToRelationShip(author);

        List<ReturnTransactionsRelationShip> returnTransactionsRelationShipList = new ArrayList<>();
        relationShipList.parallelStream().collect(groupingBy(ReturnTransactionsRelationShip::self, summingDouble(ReturnTransactionsRelationShip::getTransactionvalue)))
                .forEach((key, value) -> {
                    key.setTransactionvalue(value);
                    returnTransactionsRelationShipList.add(key);
                });

        logger.info("size = " + returnTransactionsRelationShipList.size());

        return ResponseEntity.ok(returnTransactionsRelationShipList);
    }
}
