package com.xiaop.javalearndemo.other.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Tile:
 * @Author: 段晓平
 * @Date 2022/2/22
 * @Description:
 */
@Slf4j
public class ConcurrentUtils {

    private static final Exchanger<String> exchanger = new Exchanger<String>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    String msg = "candy";
                    String returnMsg = exchanger.exchange(msg);
                    log.info("candy的返回值：{}",returnMsg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = "糖糖";
                    String returnMsg = exchanger.exchange(msg);
                    log.info("糖糖的返回值：{}",returnMsg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = "唐棠";
                    String returnMsg = exchanger.exchange(msg);
                    log.info("唐棠的返回值：{}",returnMsg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
