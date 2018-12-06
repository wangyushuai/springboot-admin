package com.example.springbootadmin.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wangyushuai@fang.com
 * @date 2018/12/5
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String deault() {
        return "Welcome come to SpringBoot Admin Client!";
    }

}
