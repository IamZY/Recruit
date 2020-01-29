package com.ntuzy.recruit;

import java.util.concurrent.TimeUnit;

/**
 * @Author IamZY
 * @create 2020/1/29 20:57
 */

class HoldThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockA + "尝试获得" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockB + "尝试获得" + lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args){
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldThread(lockA,lockB),"AAA").start();
        new Thread(new HoldThread(lockA,lockB),"BBB").start();

    }
}
