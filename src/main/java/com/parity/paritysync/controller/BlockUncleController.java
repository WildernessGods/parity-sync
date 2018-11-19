package com.parity.paritysync.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parity.paritysync.bean.Block;
import com.parity.paritysync.bean.BlockUncle;
import com.parity.paritysync.returntype.ReturnBlockUncle;
import com.parity.paritysync.service.BlockUncleService;
import com.parity.paritysync.utils.ParityLog;
import com.parity.paritysync.utils.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.parity.paritysync.utils.ReturnMessage.OPERATE_SUCCESS;

@RestController
public class BlockUncleController {

    private final BlockUncleService blockUncleService;

    public BlockUncleController(BlockUncleService blockUncleService) {
        this.blockUncleService = blockUncleService;
    }

    @ParityLog("分页查询所有区块数据")
    @GetMapping("/blockUncle")
    public ReturnMessage read(@RequestParam("pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 20);
        List<ReturnBlockUncle> blockUncleList = blockUncleService.selectAll();
        PageInfo<ReturnBlockUncle> pageInfo = new PageInfo<>(blockUncleList);
        return ReturnMessage.success(OPERATE_SUCCESS).add("block", pageInfo);
    }
}
