package com.xiaop.javalearndemo.common.enumerate;

import java.math.BigDecimal;

/**
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/4/15
 */
public enum DishEnum {

    /** 牛肉*/
    RED_COOKED_BEEF("红烧牛肉","肉类",15736,new BigDecimal(52)),
    RED_COOKED_PORK("红烧肉","肉类",15736,new BigDecimal(52)),
    BULLFROG("牛蛙","肉类",15000,new BigDecimal(42)),
    RED_COOKED_SHARKSUCKER("红烧鲫鱼","鱼类",15736,new BigDecimal(36)),
    STEAMING_FISH("清蒸鱼","鱼类",12000,new BigDecimal(32)),
    PAKCHOI("小白菜","素食",300,new BigDecimal(12)),
    WATER_SPINACH("空心菜","素食",400,new BigDecimal(13)),
    ;

    DishEnum(String name, String type, int calories, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
    }

    /** 名称 */
    private String name;
    /** 菜品类型*/
    private String type;
    /** 热量-卡路里*/
    private int calories;
    /** 菜品价格*/
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
