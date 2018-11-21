package com.parity.paritysync;

import com.parity.paritysync.utils.parity.ParityUpdateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultCommonSyncApplicationTests {

    @Autowired
    private ParityUpdateUtil parityUpdateUtil;

    @Test
    public void insertParity() {
        parityUpdateUtil.insertParity(2834812, 4_200_000);
    }

    @Test
    public void updateParity() {
        parityUpdateUtil.updateParity(0, 2447761);
    }

    @Test
    public void updateUncles() {
        parityUpdateUtil.traversingUncles(500000, 2789989);
    }

    @Test
    public void dailyTradingVolume() {
        parityUpdateUtil.dailyTradingVolume();
    }

    @Test
    public void updateAuthor() {
        parityUpdateUtil.updateAuthor(1, 1000L);
    }
}
