package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")

public class HelloController {

    @Value("${school.name}")
    private String schoolNmae;
    @Value("${school.website}")
    private String website;

    @Autowired
    public TestConfigInfo aConfigInfo;

    @RequestMapping("/h1")
    @ResponseBody
    private String helloxxxx() {
        System.out.println("call helloxxxx");
//        return String.format("{\"school_name\":\"%s\",\"website\":\"%s\"}",schoolNmae,website);
        return String.format("{\"school_name\":\"%s\",\"website\":\"%s\"}",aConfigInfo.website,aConfigInfo.name);
    }
}
