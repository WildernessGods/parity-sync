package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.bean.Block;
import com.parity.paritysync.service.BlockService;
import com.parity.paritysync.utils.ParityLog;
import com.parity.paritysync.utils.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.parity.paritysync.utils.ReturnMessage.OPERATE_SUCCESS;

@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @ParityLog("分页查询所有区块数据")
    @GetMapping("/block")
    public ReturnMessage read(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 20);
        List<Block> blockList = blockService.selectAll(pageNum * 20);
        PageInfo<Block> pageInfo = new PageInfo<>(blockList);
        return ReturnMessage.success(OPERATE_SUCCESS).add("block", pageInfo);
    }

    @ParityLog("根据区块号查询区块数据")
    @GetMapping("/block/blockNumber")
    public ReturnMessage readByBlockNumber(@RequestParam("blockNumber") Long blockNumber) {
        return ReturnMessage.success(OPERATE_SUCCESS).add("block", blockService.selectByPrimaryKey(blockNumber));
    }

    @ParityLog("根据区块哈希查询区块数据")
    @GetMapping("/block/blockHash")
    public ReturnMessage readByBlockHash(@RequestParam("blockHash") String blockHash) {
        return ReturnMessage.success(OPERATE_SUCCESS).add("block", blockService.selectByHash(blockHash));
    }

    @GetMapping("/block/author/{author}")
    public ReturnMessage readByBlockAuthor(@RequestParam("pageNum") Integer pageNum, @RequestParam("author") String author) {

        PageHelper.startPage(pageNum, 20);
        List<Block> blockList = blockService.selectByAuthor(author);
        PageInfo<Block> pageInfo = new PageInfo<>(blockList);
        return ReturnMessage.success(OPERATE_SUCCESS).add("block", pageInfo);
    }
}
