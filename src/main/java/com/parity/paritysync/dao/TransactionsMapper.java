package com.parity.paritysync.dao;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionsMapper {

    int insert(TransactionsWithBLOBs record);

    int insertSelective(TransactionsWithBLOBs record);

    TransactionsWithBLOBs selectByPrimaryKey(Integer id);

    int batchInsertSelective(List<TransactionsWithBLOBs> transactionsWithBLOBsList);

    ReturnTransactions selectByTxHash(String hash);

    List<ReturnTransactions> selectByBlockHash(String blockHash);

    List<ReturnTransactions> selectByBlockNumber(Long blockNumber);

    List<TransactionsWithBLOBs> selectByPageNum(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    List<ReturnTransactions> selectAll(Long index);

    long selectAll_COUNT();

    List<ReturnTransactions> selectByAuthor(@Param("author") String author, @Param("index") Long index);

    long selectCountByAuthor(String address);

    long selectByAuthor_COUNT(String author);

    List<ReturnContractTransactions> selectByCreatest(Long index);

    int selectByCreatest_COUNT();

    List<ReturnTransactions> selectForSearchByAuthor(String address);
}