package com.ntuzy.recruit;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author IamZY
 * @create 2020/1/23 9:53
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c");
        List<String> list = new ArrayList<>(); // new Vector<>(); //new ArrayList<>();
//        list.stream().forEach(System.out::println);
        // CopyOnWriteArrayList
        List<String> newList = Collections.synchronizedList(list);


        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                newList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(newList);
            }, String.valueOf(i)).start();
        }

//        HashSet

        /**
         * 故障现象
         *      java.util.ConcurrentModificationException
         * 导致原因
         *      并发争抢修改告知
         *
         * 解决方案
         *          Vector
         *          Collections.synchronizedList
         *          CopyOnWriteArrayList // 写时复制
         * 优化建议
         *
         *
         */

    }
}
