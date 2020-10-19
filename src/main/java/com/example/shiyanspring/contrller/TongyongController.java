package com.example.shiyanspring.contrller;

import com.example.shiyanspring.Service.Tongyongservice;
import com.example.shiyanspring.pojo.Usertongyong;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "/",description = "这是tk通用方法测试的接口文档")
@RequestMapping("/tong")
public class TongyongController {
    @Autowired
    Tongyongservice tongyongservice;
    @RequestMapping(value = "/yong",method = RequestMethod.GET)
    @ApiOperation(value="通用mapper测试",httpMethod = "GET")
    public List<Usertongyong> findall(){
        return tongyongservice.findall();
    }
}
