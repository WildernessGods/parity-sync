package com.parity.paritysync.dao;

import com.parity.paritysync.bean.DailyTradingVolume;
import org.springframework.stereotype.Component;

@Component
public interface DailyTradingVolumeMapper {

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(DailyTradingVolume record);

    Integer insertSelective(DailyTradingVolume record);

    DailyTradingVolume selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(DailyTradingVolume record);

    Integer updateByPrimaryKey(DailyTradingVolume record);

    DailyTradingVolume selectByDate(String transactionDate);
}