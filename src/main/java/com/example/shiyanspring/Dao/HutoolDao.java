package com.example.shiyanspring.Dao;

import com.example.shiyanspring.pojo.Hutool;
import com.example.shiyanspring.pojo.JemteTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HutoolDao {
    List<Hutool> findlist();
    int addall(JemteTest jemteTest);
}
