package com.xiaop.javalearndemo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Tile:
 * @Author: xiaoping.duan
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
