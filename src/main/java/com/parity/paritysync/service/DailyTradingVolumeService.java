package com.parity.paritysync.service;

import com.parity.paritysync.bean.DailyTradingVolume;
import com.parity.paritysync.dao.DailyTradingVolumeMapper;
import org.springframework.stereotype.Service;

@Service
public class DailyTradingVolumeService {

    private final DailyTradingVolumeMapper dailyTradingVolumeMapper;

    public DailyTradingVolumeService(DailyTradingVolumeMapper dailyTradingVolumeMapper) {
        this.dailyTradingVolumeMapper = dailyTradingVolumeMapper;
    }

    public int insertSelective(DailyTradingVolume dailyTradingVolume) {
        return dailyTradingVolumeMapper.insertSelective(dailyTradingVolume);
    }

    public DailyTradingVolume selectByDate(String transactionDate) {
        return dailyTradingVolumeMapper.selectByDate(transactionDate);
    }

    public int updateByPrimaryKeySelective(DailyTradingVolume dailyTradingVolume) {
        return dailyTradingVolumeMapper.updateByPrimaryKeySelective(dailyTradingVolume);
    }
}
