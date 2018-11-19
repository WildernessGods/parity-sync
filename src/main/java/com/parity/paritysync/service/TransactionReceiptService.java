package com.parity.paritysync.service;

import com.parity.paritysync.bean.TransactionReceipt;
import com.parity.paritysync.dao.TransactionReceiptMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionReceiptService {

    private final TransactionReceiptMapper transactionReceiptMapper;

    public TransactionReceiptService(TransactionReceiptMapper transactionReceiptMapper) {
        this.transactionReceiptMapper = transactionReceiptMapper;
    }

    public TransactionReceipt selectByTransactionHash(String transactionHash) {
        return transactionReceiptMapper.selectByTransactionHash(transactionHash);
    }

    public int insertSelective(TransactionReceipt transactionReceipt) {
        return transactionReceiptMapper.insertSelective(transactionReceipt);
    }
}
