package com.example.shiyanspring.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/1314")
public class USerController {
    @RequestMapping("/520")
public String sss(){

    return "untitled";
}


    @RequestMapping("/521")
    public String sss1(){

        return "index";
    }
}
