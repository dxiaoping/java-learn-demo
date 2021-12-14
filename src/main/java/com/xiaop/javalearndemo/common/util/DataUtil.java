package com.xiaop.javalearndemo.common.util;


import com.xiaop.javalearndemo.common.entity.Apple;
import com.xiaop.javalearndemo.common.entity.Dish;
import com.xiaop.javalearndemo.common.enumerate.ColorEnum;
import com.xiaop.javalearndemo.common.enumerate.DishEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/4/15
 */
public class DataUtil {
    private static Random random = new Random();

    private static final String RED = "red";
    private static final String YELLOW = "yellow";
    private static final String GREEN = "green";

    private static ColorEnum[] COLORS = {ColorEnum.RED,ColorEnum.GREEN,ColorEnum.YELLOW};

    /** 创建一系列苹果 */
    public static List<Apple> createApples(int num) {
        List<Apple> list = new ArrayList<>(num);
        // 平均重量
        BigDecimal level = new BigDecimal("150");
        // 最大差值
        BigDecimal disparity = new BigDecimal("20");

        for (int index = 0; index < num; index++) {
            list.add(new Apple(COLORS[random.nextInt(3)].getValue(),
                    level.subtract(disparity)
                            .add(new BigDecimal(random.nextInt(40)))
                            .add(new BigDecimal(random.nextFloat()))));
        }
        return list;
    }

    /** 创建一系列菜品*/
    public static List<Dish> createDishs(){
        List<Dish> list = new ArrayList<>(DishEnum.values().length);
        for (DishEnum e :DishEnum.values()) {
            list.add(new Dish(e.getName(),e.getType(),e.getCalories(),e.getPrice()));
        }
        return list;
    }
}
