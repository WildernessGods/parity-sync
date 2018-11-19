package com.parity.paritysync.service;

import com.parity.paritysync.bean.ReceiptLogs;
import com.parity.paritysync.bean.ReceiptLogsKey;
import com.parity.paritysync.dao.ReceiptLogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptLogsService {

    private final ReceiptLogsMapper receiptLogsMapper;

    public ReceiptLogsService(ReceiptLogsMapper receiptLogsMapper) {
        this.receiptLogsMapper = receiptLogsMapper;
    }

    public int insertSelective(ReceiptLogs receiptLogs) {
        return receiptLogsMapper.insertSelective(receiptLogs);
    }
}
