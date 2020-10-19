package com.example.shiyanspring.contrller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.example.shiyanspring.Service.HutoolService;
import com.example.shiyanspring.pojo.Hutool;
import com.example.shiyanspring.pojo.JemteTest;
import com.example.shiyanspring.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "/",description = "这是hutool")
@RequestMapping("/hutool")
public class HutoolController {
    @Autowired
    HutoolService hutoolService;

    @RequestMapping(value = "/findlist",method = RequestMethod.GET)
    @ApiOperation(value="查询t_menu",httpMethod = "GET")
    public Result findlist(){
        Result result=new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);

        result.setDetail(hutoolService.findlist());
        return result;
    }

    @RequestMapping(value = "/addall",method = RequestMethod.POST)
    @ApiOperation(value="插入数据",httpMethod = "POST")
    public Result addall(@RequestBody JemteTest jemteTest){
        Result result=new Result();
        int a=hutoolService.addall(jemteTest);
        if(a>=1){
            result.setMsg("插入成功");
            result.setSuccess(true);
            result.setDetail(a);

        }
        return result;
    }
}
