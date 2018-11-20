package com.parity.paritysync.dao;

import com.parity.paritysync.bean.ReceiptLogs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReceiptLogsMapper {

    int insert(ReceiptLogs record);

    int insertSelective(ReceiptLogs record);

    int updateByPrimaryKeySelective(ReceiptLogs record);

    int updateByPrimaryKey(ReceiptLogs record);

    int batchInsert(List<ReceiptLogs> receiptLogsList);
}