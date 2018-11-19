package com.parity.paritysync.service;

import com.parity.paritysync.bean.Block;
import com.parity.paritysync.dao.BlockMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    private Logger logger = LoggerFactory.getLogger(BlockService.class);

    private final BlockMapper blockMapper;

    public BlockService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<Block> selectAll(Long index) {
        return blockMapper.selectAll(index);
    }

    public List<Block> selectByDate(String date) {
        return blockMapper.selectByDate(date);
    }

    public List<Block> selectByPage(Integer pageOffset, Integer pageSize) {
        return blockMapper.selectByPage(pageOffset, pageSize);
    }

    public List<Block> selectByAuthor(String author) {
        return blockMapper.selectByAuthor(author);
    }

    public int selectCountByAuthor(String author) {
        return blockMapper.selectCountByAuthor(author);
    }

    public Block selectByPrimaryKey(Long number) {
        return blockMapper.selectByPrimaryKey(number);
    }

    public Block selectByHash(String hash) {
        return blockMapper.selectByHash(hash);
    }

    public int insertSelective(Block block) {
        return blockMapper.insertSelective(block);
    }

    public int batchInsertSelective(List<Block> blockList) {
        return blockMapper.batchInsertSelective(blockList);
    }

    public int updateByPrimaryKeySelective(Block block) {
        return blockMapper.updateByPrimaryKeySelective(block);
    }
}
