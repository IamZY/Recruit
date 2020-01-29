package com.ntuzy.recruit;

import org.omg.SendingContext.RunTime;

import java.util.Collections;
import java.util.concurrent.*;

/**
 * @Author IamZY
 * @create 2020/1/29 15:54
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {


        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {

            for(int i = 1;i <= 9;i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务... ");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    public void threadPoolInit() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一池可扩容个处理线程

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {

            for(int i = 1;i <= 20;i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务... ");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
