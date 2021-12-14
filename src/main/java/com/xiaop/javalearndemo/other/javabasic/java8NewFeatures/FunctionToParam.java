package com.xiaop.javalearndemo.other.javabasic.java8NewFeatures;

import com.xiaop.javalearndemo.common.util.DataUtil;
import com.xiaop.javalearndemo.common.enumerate.ColorEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import com.xiaop.javalearndemo.common.entity.Apple;
import static java.util.stream.Collectors.toList;

/**
 * @Tile: Java_8 新特新方法参数化
 * @Author xiaoping.duan
 * @Date 2021/3/26
 */
@Slf4j
public class FunctionToParam {

    @Test
    public void test() {
        List<Apple> list = DataUtil.createApples(100);



//        printList(list);
//        System.out.println(Apple.filterApples(list, Apple::isHeavyApple));
//        System.out.println(Apple.filterApples(list, (Apple apple) -> "red".equals(apple.getColor())));
        // 顺序筛选苹果
        list = list.stream().filter((Apple a) -> ColorEnum.RED.getValue().equals(a.getColor())).collect(toList());
        long start = System.currentTimeMillis();
        list = list.stream().filter((Apple a) -> a.getWeight().compareTo(new BigDecimal("150")) == 1).collect(toList());
        long end = System.currentTimeMillis();
        log.info("顺序处理时间：{}",end - start);
        // 并行处理
        start = System.currentTimeMillis();
        list = list.parallelStream().filter((Apple a) -> a.getWeight().compareTo(new BigDecimal("150")) == 1).collect(toList());
        end = System.currentTimeMillis();
        log.info("并行处理时间：{}",end - start);
        printList(list);
    }

    @Test
    public void reduce(){
        Integer[] num = {1,2,3,4,5,6,7,8,9};
        List<Integer> numbers = Arrays.asList(num);
        int res = numbers.parallelStream().reduce(0,(a,b)->a+b);
        log.info("累加结果：{}",res);
    }

    public void printList(List list){
        for (Object t:list) {
            System.out.println(t);
        }
    }
}


