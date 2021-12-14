package com.xiaop.javalearndemo.other.thread;

import com.xiaop.javalearndemo.other.templateobject.TempObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Tile:
 * @Author: xiaoping.duan
 * @Date 2021/3/3
 */
public class TestDemo {

    Logger logger = LoggerFactory.getLogger(TestDemo.class);

//    @Test
    public void demo1(){
        Runnable runnable = () -> {
            logger.info("执行任务-1-");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

//    @Test
    public void threadPool() throws InterruptedException {
        TempObject tempObject = new TempObject();
        AtomicInteger atomicInteger = new AtomicInteger();
        tempObject.setNum(0);
        class Runn implements Runnable {
            // 内部类引用外部类变量的前提为：对象引用不再改变
            @Override
            public void run() {
                tempObject.setNum(tempObject.getNum()+1);
                atomicInteger.getAndAdd(1);
                logger.info("执行任务:{}",tempObject.getNum());
            }
        }
        Runnable runnable = new Runn();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3,
                5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i =0;i<100000;i++){
            pool.execute(runnable);
        }
        pool.shutdown();
        pool.awaitTermination(20,TimeUnit.SECONDS);
        logger.info("最终结果 tempObject:{}",tempObject.getNum());
        logger.info("最终结果 atomicInteger:{}",atomicInteger.get());
    }

//    @Test
    public void threadLocalTest() throws InterruptedException {
        final ThreadLocal<TempObject> userThreadLocal = new ThreadLocal<TempObject>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5,
                5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        TempObject tempObject = new TempObject();
        userThreadLocal.set(tempObject);
        Runnable runnable = ()->{
            TempObject currentObject = userThreadLocal.get();
            currentObject.setNum(currentObject.getNum()+1);
            logger.info("执行任务:{}",currentObject.getNum());
        };
        for (int i =0;i<10;i++){
            pool.execute(runnable);
        }
        pool.shutdown();
        pool.awaitTermination(20,TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5,
                5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i =0;i<1000000;i++){
            pool.execute(new NotSafeThread());
        }
        pool.shutdown();
        pool.awaitTermination(20,TimeUnit.SECONDS);
    }

}
class NotSafeThread implements Runnable {

    public static TempObject number = new TempObject();

    public static int i = 0;

    @Override
    public void run() {
        //每个线程计数加一
        number.setNum(i++);
        //将其存储到ThreadLocal中
        value.set(number);
        //延时2秒
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//        }
        //输出num值
        System.out.println(value.get().getNum());
//        System.out.println(i++);
    }

    public static ThreadLocal<TempObject> value = new ThreadLocal<TempObject>();
}
