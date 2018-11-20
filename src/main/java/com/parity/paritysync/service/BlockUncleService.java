package com.parity.paritysync.service;

import com.parity.paritysync.bean.BlockUncle;
import com.parity.paritysync.dao.BlockUncleMapper;
import com.parity.paritysync.returntype.ReturnBlockUncle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockUncleService {

    private final BlockUncleMapper blockUncleMapper;

    public BlockUncleService(BlockUncleMapper blockUncleMapper) {
        this.blockUncleMapper = blockUncleMapper;
    }

    public BlockUncle selectByPrimaryKey(String hash) {
        return blockUncleMapper.selectByPrimaryKey(hash);
    }

    public List<BlockUncle> selectByUncleByHash(String uncleByHash) {
        return blockUncleMapper.selectByUncleByHash(uncleByHash);
    }

    public int insertSelective(BlockUncle blockUncle) {
        return blockUncleMapper.insertSelective(blockUncle);
    }

    public List<ReturnBlockUncle> selectAll() {
        return blockUncleMapper.selectAll();
    }

    public int updateByPrimaryKeySelective(BlockUncle blockUncle) {
        return blockUncleMapper.updateByPrimaryKeySelective(blockUncle);
    }

    public long selectCountByAuthor(String address) {
        return blockUncleMapper.selectCountByAuthor(address);
    }
}
