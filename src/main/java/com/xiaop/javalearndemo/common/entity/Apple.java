package com.xiaop.javalearndemo.common.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 苹果实体类
 * @Tile:
 * @Author: xiaoping.duan
 * @Date: 2021/4/15
 */
@Data
public class Apple {

    public Apple(String color, BigDecimal weight) {
        this.color = color;
        this.weight = weight;
    }

    /**
     * <hr><blockquote><pre>
     *     对象属性
     * 颜色*/
    private String color;

    /** 重量*/
    private BigDecimal weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight().compareTo(new BigDecimal("150")) == 1;
    }

    @FunctionalInterface
    public interface Predicate<T> {
        boolean filter(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory,
                                    Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
