package com.parity.paritysync.dao;

import com.parity.paritysync.bean.BlockUncle;
import com.parity.paritysync.returntype.ReturnBlockUncle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlockUncleMapper {

    int insert(BlockUncle record);

    int insertSelective(BlockUncle record);

    BlockUncle selectByPrimaryKey(String hash);

    int updateByPrimaryKeySelective(BlockUncle record);

    int updateByPrimaryKey(BlockUncle record);

    List<BlockUncle> selectByUncleByHash(String uncleByHash);

    List<ReturnBlockUncle> selectAll();

    long selectCountByAuthor(String address);
}