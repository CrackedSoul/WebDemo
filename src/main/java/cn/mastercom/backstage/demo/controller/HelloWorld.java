package cn.mastercom.backstage.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    @GetMapping("/hello")
    public String hello(){
        return  "Hello ,Time is "+new Date().toString();
    }
}
