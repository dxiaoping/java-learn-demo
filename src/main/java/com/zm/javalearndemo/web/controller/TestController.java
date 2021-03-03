package com.zm.javalearndemo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Tile: NTS20110100148  广州一体化项目Oracle环境测试、问题修复
 * @Author: xiaoping.duan 医保研发5部 CN32219
 * @Date 2021/2/18
 */
@RestController
@RequestMapping("/java-learn/test")
@Slf4j
public class TestController {
    @GetMapping("sayHello")
    public String sayHello(){
        log.info("say hello");
        return "Hello";
    }

    
}
