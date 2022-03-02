package com.xiaop.javalearndemo.web.controller;

import com.xiaop.javalearndemo.web.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/2/18
 */
@RestController
@RequestMapping("/java-learn/test")
@Slf4j
public class TestController {

    @Resource
    BaseService baseService;

    @GetMapping("sayHello")
    public String sayHello(){
        log.info("say hello");
        baseService.firstMethodTest();
        return "Hello";
    }


}
