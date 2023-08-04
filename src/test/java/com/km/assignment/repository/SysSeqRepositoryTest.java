package com.km.assignment.repository;

import com.km.assignment.entity.SysSeq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSeqRepositoryTest {

    @Autowired
    private SysSeqRepository sysSeqRepository;


    @Test
    void testFindByKey() {
        SysSeq sysSeq = sysSeqRepository.findByKey("Order20230803");
        assertEquals("Order20230803", sysSeq.getSeqKey());
    }

    @Test
    void testInsertSysSeq() {
        SysSeq sysSeq = new SysSeq();
        sysSeq.setId(UUID.randomUUID().toString().replace("-", ""));
        sysSeq.setSeqKey("Order20230804");
        sysSeq.setValue(1);

        Integer inserted = sysSeqRepository.insert(sysSeq);
        assertEquals(1, inserted);
    }

    @Test
    void testUpdateValue() {
        SysSeq sysSeq = new SysSeq();
        sysSeq.setId(UUID.randomUUID().toString().replace("-", ""));
        sysSeq.setSeqKey("Order20230804");
        sysSeq.setValue(2);
        Integer updated = sysSeqRepository.updateValue(sysSeq);
        assertEquals(1, updated);
    }
}