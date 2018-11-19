package com.parity.paritysync.dao;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionsMapper {

    Integer insert(TransactionsWithBLOBs record);

    Integer insertSelective(TransactionsWithBLOBs record);

    TransactionsWithBLOBs selectByPrimaryKey(Integer id);

    Integer batchInsertSelective(List<TransactionsWithBLOBs> transactionsWithBLOBsList);

    ReturnTransactions selectByTxHash(String hash);

    List<ReturnTransactions> selectByBlockHash(String blockHash);

    List<ReturnTransactions> selectByBlockNumber(Long blockNumber);

    List<TransactionsWithBLOBs> selectByPageNum(@Param("index") Integer index, @Param("pageSize") Integer pageSize);


    /*分页查询交易记录优化方案*/
    List<ReturnTransactions> selectAll();

    Long selectAll_COUNT();

    List<ReturnTransactions> selectAllOpt1(Long index);

    List<ReturnTransactions> selectAllOpt2(@Param("index1") Long index1, @Param("index2") Long index2);

    List<ReturnTransactions> selectAllOpt3(Long index);

    Long selectAllOpt1_COUNT();

    Long selectAllOpt2_COUNT();

    Long selectAllOpt3_COUNT();


    /*根据地址查询交易记录*/
    List<ReturnTransactions> selectByAuthor(@Param("author") String author);

    Long selectByAuthor_COUNT(String author);

    List<ReturnTransactions> selectByAuthorOpt(@Param("author") String author, @Param("index") Long index);

    Long selectByAuthorOpt_COUNT(String author);

    List<ReturnContractTransactions> selectByCreatest(Long index);

    Integer selectByCreatest_COUNT();
}