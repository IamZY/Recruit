package com.ntuzy.recruit;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author IamZY
 * @create 2020/1/28 15:35
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
//        List list = null;

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.add("d"));


    }
}
