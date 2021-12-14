package com.xiaop.javalearndemo.other.javabasic.java8NewFeatures;

import com.xiaop.javalearndemo.common.util.DataUtil;
import com.xiaop.javalearndemo.common.entity.Dish;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @Author: xiaoping.duan
 * @Date 2021/4/8
 */
@Slf4j
public class Stream {

    public enum CaloricLevel { DIET, NORMAL, FAT }

    @Test
    public void test1(){
        List<Dish> menu = DataUtil.createDishs();
        // 获取菜品的名字
        List<String> dishName = menu.stream().map(Dish::getName).collect(Collectors.toList());
        // 规约 筛选 匹配
        int calories = menu.stream().filter((Dish dish)->"肉类".equals(dish.getType())).collect(Collectors.summingInt(Dish::getCalories));
        Optional<BigDecimal> totalPrice = menu.stream().filter((Dish dish)->"肉类".equals(dish.getType())).map(Dish::getPrice)
                .reduce((BigDecimal price1,BigDecimal price2) -> price1.add(price2));
        Optional<Dish> dish = menu.parallelStream()
//                .filter((Dish d)->"肉类".equals(d.getType()))
                .findAny();
        // 菜品类型分组
        Map<String,List<Dish>> menuGroupByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Map<String,List<Dish>> menuGroupByCalories = menu.stream().collect(
                Collectors.groupingBy(
                        dishTemp->{
                            if (dishTemp.getCalories() > 1000) {
                                return "高热量食品";
                            }else {
                                return "低热量食品";
                            }
                            // Collectors.toList() 可省略
                        },Collectors.toList()));
        System.out.println(dishName);
        System.out.println(menuGroupByType.entrySet());
        log.info("通过热量进行分组：{}",menuGroupByCalories.entrySet());
        log.info("肉类总热量：{}",calories);
        log.info("肉类总价格：{}",totalPrice);
        dish.ifPresent((d)->log.info("随机获取一道菜品：{}",d.getName()));
    }
}
