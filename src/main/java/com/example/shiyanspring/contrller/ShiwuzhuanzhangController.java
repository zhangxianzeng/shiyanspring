package com.example.shiyanspring.contrller;

import com.example.shiyanspring.Service.ShiwuzhuanzhangService;
import com.example.shiyanspring.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shiwu")
@Api(value = "/",description = "转账测试")
public class ShiwuzhuanzhangController {
    @Autowired
    ShiwuzhuanzhangService shiwuzhuanzhangService;
    @RequestMapping(value = "/zhuanzhang",method = RequestMethod.POST)
    @ApiOperation(value="转账",httpMethod = "POST")
    public Result zhuanzhang(String outusername, String inusername, Integer money){
      shiwuzhuanzhangService.trade3(outusername,inusername,money);
        Result result=new Result();
        result.setMsg("成功");

        return result;
    }
}
