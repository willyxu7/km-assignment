package com.km.assignment.service.impl;

import com.km.assignment.entity.SysSeq;
import com.km.assignment.repository.SysSeqRepository;
import com.km.assignment.service.SysSeqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class SysSeqServiceImpl implements SysSeqService {

    @Autowired
    private SysSeqRepository sysSeqRepository;

    @Override
    public Long getSeq(String key) {
        SysSeq sysSeq = sysSeqRepository.findByKey(key);
        if(sysSeq == null) {
            sysSeq = new SysSeq();
            sysSeq.setId(UUID.randomUUID().toString().replace("-", ""));
            sysSeq.setSeqKey(key);
            sysSeq.setValue(sysSeq.getValue() + 1);
            sysSeqRepository.insert(sysSeq);
        } else {
            sysSeq.setValue(sysSeq.getValue() + 1);
            sysSeqRepository.updateValue(sysSeq);
        }
        return sysSeq.getValue();
    }
}
