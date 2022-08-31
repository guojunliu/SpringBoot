package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")

public class TestController {

    @RequestMapping("/h2")
    @ResponseBody
    public  String hello() {
        return "{\"aa\":\"xxxxxx\"}";
    }
}