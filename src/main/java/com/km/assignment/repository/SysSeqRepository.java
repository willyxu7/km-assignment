package com.km.assignment.repository;

import com.km.assignment.entity.SysSeq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SysSeqRepository {

//    @Select("SELECT * FROM sys_seq WHERE seq_key = #{seqKey} FOR UPDATE")
    public SysSeq findByKey(String key);

//    @Insert("INSERT INTO sys_seq(ID, seq_key, value) VALUES (#{id}, #{seqKey}, #{value})")
    public Integer insert(SysSeq sysSeq);

//    @Update("UPDATE sys_seq SET value=#{value} WHERE seq_key=#{seqKey}")
    public Integer updateValue(SysSeq sysSeq);

}
