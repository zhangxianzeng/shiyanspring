package com.example.shiyanspring.Dao;

import com.example.shiyanspring.pojo.Usertongyong;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Component
public interface Tongyongmapper extends BaseMapper<Usertongyong> {
}
