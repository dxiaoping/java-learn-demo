package com.zm.javalearndemo.other.javabasic.java8NewFeatures;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * @Tile: Java_8 新特新方法参数化
 * @Author xiaoping.duan 医保研发5部 CN32219
 * @Date 2021/3/26
 */
@Slf4j
public class FunctionToParam {

    @Test
    public void test() {
        List<Apple> list = Apple.createApples(1000000);

//        Apple apple1 = new Apple("green", 161);
//        list.add(apple1);
//        Apple apple2 = new Apple("red", 158);
//        list.add(apple2);
//        Apple apple3 = new Apple("green", 136);
//        list.add(apple3);
//        Apple apple4 = new Apple("red", 48);
//        list.add(apple4);
//        Apple apple5 = new Apple("yellow", 76);
//        list.add(apple5);
//        Apple apple6 = new Apple("red", 54);
//        list.add(apple6);
//        Apple apple7 = new Apple("green", 31);
//        list.add(apple7);

//        printList(list);
//        System.out.println(Apple.filterApples(list, Apple::isHeavyApple));
//        System.out.println(Apple.filterApples(list, (Apple apple) -> "red".equals(apple.getColor())));
        // 顺序筛选苹果
        long start = System.currentTimeMillis();
        list = list.stream().filter((Apple a) -> a.getWeight().compareTo(new BigDecimal("150")) == 1).collect(toList());
        long end = System.currentTimeMillis();
        log.info("顺序处理时间：{}",end - start);
        // 并行处理
        start = System.currentTimeMillis();
        list = list.parallelStream().filter((Apple a) -> a.getWeight().compareTo(new BigDecimal("150")) == 1).collect(toList());
        end = System.currentTimeMillis();
        log.info("并行处理时间：{}",end - start);
//        printList(list);
    }

    public void printList(List list){
        for (Object t:list) {
            System.out.println(t);
        }
    }
}

@Data
class Apple {

    private static Random random = new Random();

    private static final String RED = "red";
    private static final String YELLOW = "yellow";
    private static final String GREEN = "green";


    private static String[] COLORS = {RED,GREEN,YELLOW};
    public Apple(String color, BigDecimal weight) {
        this.color = color;
        this.weight = weight;
    }

    /**
     * <hr><blockquote><pre>
     *     对象属性
     */
    /* */
    private String color;

    private BigDecimal weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight().compareTo(new BigDecimal("150")) == 1;
    }

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

    /* 数据初始化 */
    public static List<Apple> createApples(int num) {
        List<Apple> list = new ArrayList<>(num);
        BigDecimal level = new BigDecimal("150");
        BigDecimal disparity = new BigDecimal("20");

        for (int index = 0; index < num; index++) {
            list.add(new Apple(COLORS[random.nextInt(3)],
                    level.subtract(disparity)
                            .add(new BigDecimal(random.nextInt(40)))
                            .add(new BigDecimal(random.nextFloat()))));
        }
        return list;
    }

}
