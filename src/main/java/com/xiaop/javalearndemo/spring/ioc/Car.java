package com.xiaop.javalearndemo.spring.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
//@Data
public class Car {

    @Autowired
    Person person;

    private BigDecimal price;
    private String brand;

    public Car() {
        System.out.println("汽车初始化");
    }
}
