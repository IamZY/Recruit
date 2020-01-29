package com.ntuzy.recruit;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author IamZY
 * @create 2020/1/28 15:35
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        List list = null;

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//          // 插入失败抛出异常
//        System.out.println(blockingQueue.add("d"));


//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        // 插入失败返回false
//        System.out.println(blockingQueue.offer("d"));

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");

        System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));

        System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));




    }
}
