package com.xiaop.javalearndemo.common.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 菜品实体类
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/4/15
 */
@Data
public class Dish {

    public Dish(String name, String type, int calories, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
    }

    public Dish() {
    }

    /** 名称 */
    private String name;
    /** 菜品类型*/
    private String type;
    /** 热量-卡路里*/
    private int calories;
    /** 菜品价格*/
    private BigDecimal price;


}
