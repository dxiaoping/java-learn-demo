package com.xiaop.javalearndemo.spring.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Data
public class Person {

    @Autowired
    Car car;
    private String name;
    private String idCard;

    public Person() {
        System.out.println("人员初始化");
    }
}
