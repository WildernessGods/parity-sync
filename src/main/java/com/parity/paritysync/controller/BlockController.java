package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.returntype.ReturnBlock;
import com.parity.paritysync.service.BlockService;
import com.parity.paritysync.utils.ParityLog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @ParityLog("分页查询所有区块数据")
    @GetMapping("/block")
    public ResponseEntity read(@RequestParam("pageNum") Long pageNum) {

        PageHelper.startPage(0, 5);
        List<ReturnBlock> blockList = blockService.selectAll(pageNum * 5);
        PageInfo<ReturnBlock> pageInfo = new PageInfo<>(blockList);
        return ResponseEntity.ok(Mono.justOrEmpty(pageInfo));
    }

    @ParityLog("根据区块号查询区块数据")
    @GetMapping("/block/blockNumber")
    public ResponseEntity readByBlockNumber(@RequestParam("blockNumber") Long blockNumber) {
        return ResponseEntity.ok(Mono.justOrEmpty(blockService.selectByPrimaryKey(blockNumber)));
    }

    @ParityLog("根据区块哈希查询区块数据")
    @GetMapping("/block/blockHash")
    public ResponseEntity readByBlockHash(@RequestParam("blockHash") String blockHash) {
        return ResponseEntity.ok(Mono.justOrEmpty(blockService.selectByHash(blockHash)));
    }

    @ParityLog("根据地址查询区块数据")
    @GetMapping("/block/author")
    public ResponseEntity readByBlockAuthor(@RequestParam("pageNum") Integer pageNum, @RequestParam("author") String author) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnBlock> blockList = blockService.selectByAuthor(author);
        PageInfo<ReturnBlock> pageInfo = new PageInfo<>(blockList);
        return ResponseEntity.ok(Mono.justOrEmpty(pageInfo));
    }
}
