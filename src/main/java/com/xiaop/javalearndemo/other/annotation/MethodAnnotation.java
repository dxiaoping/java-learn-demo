package com.xiaop.javalearndemo.other.annotation;

import java.lang.annotation.*;

/**
 * @author xiaoping
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodAnnotation {
    String value() default "方法注解默认值";
}
