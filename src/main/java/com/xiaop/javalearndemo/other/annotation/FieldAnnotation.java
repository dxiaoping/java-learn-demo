package com.xiaop.javalearndemo.other.annotation;

import java.lang.annotation.*;

/**
 * @author xiaoping
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FieldAnnotation {
    String value() default "属性注解默认值";
}
