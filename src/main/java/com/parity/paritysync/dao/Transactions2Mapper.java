package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Transactions2;
import com.parity.paritysync.bean.Transactions2WithBLOBs;
import org.springframework.stereotype.Component;

@Component
public interface Transactions2Mapper {

    Integer deleteByPrimaryKey(Long id);

    Integer insert(Transactions2WithBLOBs record);

    Integer insertSelective(Transactions2WithBLOBs record);

    Transactions2WithBLOBs selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(Transactions2WithBLOBs record);

    Integer updateByPrimaryKeyWithBLOBs(Transactions2WithBLOBs record);

    Integer updateByPrimaryKey(Transactions2 record);
}