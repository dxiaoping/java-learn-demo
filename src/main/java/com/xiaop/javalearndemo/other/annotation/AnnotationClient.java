package com.xiaop.javalearndemo.other.annotation;

import com.xiaop.javalearndemo.web.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Tile:
 * @Author: 段晓平 医保研发5部 CN32219
 * @Date 2022/2/8
 * @Description:
 */
@Slf4j
public class AnnotationClient {

    static Map<String,Object> beanMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        AnnotationClient client = new AnnotationClient();
        Class<?> clazz = Class.forName("com.xiaop.javalearndemo.other.annotation.AnnotationTest");
        AnnotationTest test = (AnnotationTest) clazz.getConstructor().newInstance();
        client.initializeBean();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            if (field.getAnnotation(FieldAnnotation.class) != null){
                String fieldName = field.getName();
                log.info("fieldName:{}",fieldName);
                Object obj = beanMap.get("com.xiaop.javalearndemo.web.service.impl.BaseServiceImpl");
                field.set(test,obj);
            }
        }
        test.test();
        System.out.println(clazz.getMethod("test").getAnnotation(MethodAnnotation.class).value());

    }

    private void initializeBean() throws Exception{
        Class<?> serviceClazz = Class.forName("com.xiaop.javalearndemo.web.service.impl.BaseServiceImpl");
        BaseService service = (BaseService) serviceClazz.getConstructor().newInstance();
        beanMap.put(serviceClazz.getName(), service);
    }
}
