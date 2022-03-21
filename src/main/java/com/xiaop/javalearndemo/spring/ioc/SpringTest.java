package com.xiaop.javalearndemo.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object car = context.getBean("car");
        System.out.println(car);
        Object person = context.getBean("person");
        System.out.println(person);

    }
}
