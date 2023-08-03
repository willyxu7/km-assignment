package com.km.assignment.service.impl;

import com.km.assignment.helper.DateHelper;
import com.km.assignment.service.SysSeqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSeqServiceImplTest {


    @Autowired
    private SysSeqService sysSeqService;

    @Test
    void testGetSeq() {
        Long seq = sysSeqService.getSeq("Order" + DateHelper.generateDate());
        assertNotNull(seq);
        System.out.println(seq);
    }

    @Test
    void testGetSeqMultiThread() throws InterruptedException {
        int threads = 5;

        for (int i = 0; i < threads; i++) {
            new Thread(() ->  {
                Long resultSeq = sysSeqService.getSeq("Order" + DateHelper.generateDate());
                System.out.println("Thread [" + this.getClass().getName() + "] Get Seq = " + resultSeq );
            }).start();
        }
        Thread.sleep(10 * 1000);
    }
}