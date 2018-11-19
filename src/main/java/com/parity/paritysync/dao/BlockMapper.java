package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Block;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlockMapper {

    Integer deleteByPrimaryKey(Long number);

    Integer insert(Block record);

    Integer insertSelective(Block record);

    Block selectByPrimaryKey(Long number);

    Integer updateByPrimaryKeySelective(Block record);

    Integer updateByPrimaryKey(Block record);

    List<Block> selectAll(Long index);

    List<Block> selectByPage(Integer pageOffset, Integer pageSize);

    List<Block> selectByAuthor(String author);

    Integer selectCountByAuthor(String author);

    Block selectByHash(String hash);

    Integer batchInsertSelective(List<Block> blockList);

    Long selectAll_COUNT();

    List<Block> selectByDate(String date);
}