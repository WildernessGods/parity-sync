package com.parity.paritysync.controller;

import com.parity.paritysync.service.ParityTaskService;
import com.parity.paritysync.utils.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParityTaskController {

    private final ParityTaskService parityTaskService;

    public ParityTaskController(ParityTaskService parityTaskService) {
        this.parityTaskService = parityTaskService;
    }

    @GetMapping("/task")
    public ReturnMessage task() {

//        int start = 1000000;
//        int count = 100000;
//
//        for (int i = 0; i < 10; i++) {
//            parityTaskService.asyncUpdateParity(start + i * count, start + (i + 1) * count);
//        }
        return ReturnMessage.success(ReturnMessage.OPERATE_SUCCESS);
    }
}
