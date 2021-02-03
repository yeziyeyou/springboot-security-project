package com.aaron.security.controller;

import com.aaron.security.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping({"/", "/index", "/home"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/test")
    public void test(@ModelAttribute TestDto dto){
        System.out.println("dto = " + dto);
    }

}
