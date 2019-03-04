package com.parity.paritysync.dao;

import com.parity.paritysync.bean.BlockUncle;
import com.parity.paritysync.returntype.ReturnBlockUncle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlockUncleMapper {

    Integer insert(BlockUncle record);

    Integer insertSelective(BlockUncle record);

    BlockUncle selectByPrimaryKey(String hash);

    Integer updateByPrimaryKeySelective(BlockUncle record);

    Integer updateByPrimaryKey(BlockUncle record);

    List<BlockUncle> selectByUncleByHash(String uncleByHash);

    List<ReturnBlockUncle> selectAll();

    Long selectCountByAuthor(String address);
}