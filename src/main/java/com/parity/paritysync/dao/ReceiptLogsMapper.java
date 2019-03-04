package com.parity.paritysync.dao;

import com.parity.paritysync.bean.ReceiptLogs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiptLogsMapper {

    Integer insert(ReceiptLogs record);

    Integer insertSelective(ReceiptLogs record);

    Integer updateByPrimaryKeySelective(ReceiptLogs record);

    Integer updateByPrimaryKey(ReceiptLogs record);

    Integer batchInsert(List<ReceiptLogs> receiptLogsList);
}