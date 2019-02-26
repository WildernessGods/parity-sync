package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Transactions2;
import com.parity.paritysync.bean.Transactions2WithBLOBs;
import org.springframework.stereotype.Component;

@Component
public interface Transactions2Mapper {

    int deleteByPrimaryKey(Long id);

    int insert(Transactions2WithBLOBs record);

    int insertSelective(Transactions2WithBLOBs record);

    Transactions2WithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Transactions2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(Transactions2WithBLOBs record);

    int updateByPrimaryKey(Transactions2 record);
}