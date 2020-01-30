package com.ntuzy.recruit;

/**
 * @Author IamZY
 * @create 2020/1/30 11:26
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("************HelloGC");

        Thread.sleep(Integer.MAX_VALUE);

        byte[] bytes = new byte[1024*500];

    }

}
