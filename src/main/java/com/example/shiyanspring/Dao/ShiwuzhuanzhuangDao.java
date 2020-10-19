package com.example.shiyanspring.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ShiwuzhuanzhuangDao {
    void out(@Param("outusername") String outname,@Param("money") Integer money);
    void in(@Param("inusername") String inname,@Param("money") Integer money);
}
