package com.parity.paritysync.dao;

import com.parity.paritysync.bean.DailyTradingVolume;
import org.springframework.stereotype.Component;

@Component
public interface DailyTradingVolumeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DailyTradingVolume record);

    int insertSelective(DailyTradingVolume record);

    DailyTradingVolume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyTradingVolume record);

    int updateByPrimaryKey(DailyTradingVolume record);

    DailyTradingVolume selectByDate(String transactionDate);
}