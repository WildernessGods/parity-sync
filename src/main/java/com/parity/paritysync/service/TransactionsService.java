package com.parity.paritysync.service;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.dao.TransactionsMapper;
import com.parity.paritysync.returntype.ReturnTransactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return transactionsMapper.batchInsertSelective(transactionsWithBLOBsList);
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


    /*分页查询交易记录优化方案*/
    public List<ReturnTransactions> selectAll() {
        return transactionsMapper.selectAll();
    }

    public List<ReturnTransactions> selectAllOpt1(Long index) {
        return transactionsMapper.selectAllOpt1(index);
    }

    public List<ReturnTransactions> selectAllOpt2(Long index1, Long index2) {
        return transactionsMapper.selectAllOpt2(index1, index2);
    }

    public List<ReturnTransactions> selectAllOpt3(Long index) {
        return transactionsMapper.selectAllOpt3(index);
    }


    /*根据地址查询交易记录*/
    public List<ReturnTransactions> selectByAuthor(String author) {
        return transactionsMapper.selectByAuthor(author);
    }

    public List<ReturnTransactions> selectByAuthorOpt(String author, Long index) {
        return transactionsMapper.selectByAuthorOpt(author, index);
    }

}
