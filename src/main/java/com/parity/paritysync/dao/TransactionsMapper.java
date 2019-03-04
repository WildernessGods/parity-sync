package com.parity.paritysync.dao;

import com.parity.paritysync.bean.TransactionsWithBLOBs;
import com.parity.paritysync.returntype.ReturnContractTransactions;
import com.parity.paritysync.returntype.ReturnTransactions;
import com.parity.paritysync.returntype.ReturnTransactionsRelationShip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionsMapper {

    Integer insert(TransactionsWithBLOBs record);

    Integer insertSelective(TransactionsWithBLOBs record);

    TransactionsWithBLOBs selectByPrimaryKey(Long id);

    Integer batchInsertSelective(List<TransactionsWithBLOBs> transactionsWithBLOBsList);

    ReturnTransactions selectByTxHash(String hash);

    List<ReturnTransactions> selectByBlockHash(String blockHash);

    List<ReturnTransactions> selectByBlockNumber(Long blockNumber);

    List<TransactionsWithBLOBs> selectByPageNum(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    List<ReturnTransactions> selectAll(Long index);

    Long selectAll_COUNT();

    List<ReturnTransactions> selectByAuthor(@Param("address") String address, @Param("index") Long index);

    Long selectCountByAuthor(String address);

    Long selectByAuthor_COUNT(String address);

    List<ReturnContractTransactions> selectByCreatest(Long index);

    Integer selectByCreatest_COUNT();

    List<ReturnTransactions> selectForSearchByAuthor(String address);

    List<ReturnTransactionsRelationShip> selectByAuthorToRelationShip(String address);

    List<ReturnTransactionsRelationShip> selectBlockFromByAddress(String address);

    List<ReturnTransactionsRelationShip> selectBlockToByAddress(String address);
}