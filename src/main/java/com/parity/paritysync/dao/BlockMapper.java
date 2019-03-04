package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Block;
import com.parity.paritysync.returntype.ReturnBlock;
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

    List<ReturnBlock> selectAll(Long index);

    List<Block> selectByPage(Integer pageOffset, Integer pageSize);

    List<ReturnBlock> selectByAuthor(String author);

    Long selectCountByAuthor(String author);

    Block selectByHash(String hash);

    Integer batchInsertSelective(List<Block> blockList);

    Long selectallCount();

    List<Block> selectByDate(String date);
}