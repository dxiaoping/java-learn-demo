package com.xiaop.javalearndemo.common.enumerate;

/**
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/4/15
 */
public enum ColorEnum {

    /** 红色*/
    RED("red"),
    /** 黄色*/
    YELLOW("yellow"),
    /** 绿色*/
    GREEN("green");

    private String value;
    private ColorEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
