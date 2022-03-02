package com.xiaop.javalearndemo.other.annotation;

/**
 * @Tile:
 * @Author: 段晓平 医保研发5部 CN32219
 * @Date 2022/1/24
 * @Description:
 */

import com.xiaop.javalearndemo.web.service.BaseService;
import com.xiaop.javalearndemo.web.service.impl.BaseServiceImpl;

/**
 * 测试java注解类
 *
 * @author zhangqh
 * @date 2018年4月22日
 */
//@BaseAnnotation
public class AnnotationTest {

    @FieldAnnotation
    BaseServiceImpl baseServiceImpl;

    @MethodAnnotation("hello")
    public void test(){
        baseServiceImpl.firstMethodTest();
//        System.out.println();
    }

}
