package com.parity.paritysync.service;

import com.parity.paritysync.utils.parity.ParityUpdateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ParityTaskService {

    private Logger logger = LoggerFactory.getLogger(ParityTaskService.class);

    private final ParityUpdateUtil parityUpdateUtil;

    public ParityTaskService(ParityUpdateUtil parityUpdateUtil) {
        this.parityUpdateUtil = parityUpdateUtil;
    }

    @Async
    public void asyncUpdateParity(long start, long end) {
        logger.info("start = " + start + " end = " + end);
        parityUpdateUtil.insertParity(start, end);
    }
}
