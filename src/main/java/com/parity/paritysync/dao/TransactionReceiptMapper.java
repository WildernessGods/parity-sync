package com.parity.paritysync.dao;

import com.parity.paritysync.bean.TransactionReceipt;
import org.springframework.stereotype.Component;

@Component
public interface TransactionReceiptMapper {

    Integer deleteByPrimaryKey(Long id);

    Integer insert(TransactionReceipt record);

    Integer insertSelective(TransactionReceipt record);

    TransactionReceipt selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(TransactionReceipt record);

    Integer updateByPrimaryKey(TransactionReceipt record);

    TransactionReceipt selectByTransactionHash(String transactionHash);
}