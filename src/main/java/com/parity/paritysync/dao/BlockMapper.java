package com.parity.paritysync.dao;

import com.parity.paritysync.bean.Block;
import com.parity.paritysync.returntype.ReturnBlock;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlockMapper {

    int deleteByPrimaryKey(Long number);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Long number);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<ReturnBlock> selectAll(Long index);

    List<Block> selectByPage(Integer pageOffset, Integer pageSize);

    List<ReturnBlock> selectByAuthor(String author);

    long selectCountByAuthor(String author);

    Block selectByHash(String hash);

    int batchInsertSelective(List<Block> blockList);

    long selectAll_COUNT();

    List<Block> selectByDate(String date);
}