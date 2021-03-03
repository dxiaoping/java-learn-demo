package com.zm.javalearndemo.other.thread;

import com.zm.javalearndemo.other.templateobject.TempObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Tile: NTS20110100148  广州一体化项目Oracle环境测试、问题修复
 * @Author: xiaoping.duan 医保研发5部 CN32219
 * @Date 2021/3/3
 */
public class TestDemo {

    Logger logger = LoggerFactory.getLogger(TestDemo.class);
    @Test
    public void demo1(){
        Runnable runnable = () -> {
            logger.info("执行任务-1-");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Test
    public void threadPool() throws InterruptedException {
        TempObject tempObject = new TempObject();
        tempObject.setNum(0);
        class Runn implements Runnable {
            // 内部类引用外部类变量的前提为：对象引用不再改变
            @Override
            public void run() {
                tempObject.setNum(tempObject.getNum()+1);
                logger.info("执行任务:{}",tempObject.getNum());
            }
        }
        Runnable runnable = new Runn();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2,
                5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i =0;i<100000;i++){
            pool.execute(runnable);
        }
        pool.shutdown();
        pool.awaitTermination(2,TimeUnit.SECONDS);
    }
}
