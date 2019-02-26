package com.parity.paritysync.service;

import com.parity.paritysync.bean.Transactions2WithBLOBs;
import com.parity.paritysync.dao.Transactions2Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Transactions2Service {

    private Logger logger = LoggerFactory.getLogger(TransactionsService.class);

    private final Transactions2Mapper transactions2Mapper;

    public Transactions2Service(Transactions2Mapper transactions2Mapper) {
        this.transactions2Mapper = transactions2Mapper;
    }

    public int insertSelective(Transactions2WithBLOBs transactions) {
        return transactions2Mapper.insertSelective(transactions);
    }

    public Transactions2WithBLOBs selectByPrimaryKey(Long id) {
        return transactions2Mapper.selectByPrimaryKey(id);
    }

}
