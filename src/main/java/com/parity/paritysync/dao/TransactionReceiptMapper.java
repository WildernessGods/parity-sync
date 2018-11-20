package com.parity.paritysync.dao;

import com.parity.paritysync.bean.TransactionReceipt;
import org.springframework.stereotype.Component;

@Component
public interface TransactionReceiptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TransactionReceipt record);

    int insertSelective(TransactionReceipt record);

    TransactionReceipt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransactionReceipt record);

    int updateByPrimaryKey(TransactionReceipt record);

    TransactionReceipt selectByTransactionHash(String transactionHash);
}