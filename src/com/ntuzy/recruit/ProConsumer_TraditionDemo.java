package com.ntuzy.recruit;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程操作资源类
 *
 * @Author IamZY
 * @create 2020/1/29 10:34
 */

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();

        try {
            // 判断
            while (number != 0) {
                // 等待 不能生产
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrease() throws Exception {
        lock.lock();

        try {
            // 判断
            while (number == 0) {
                // 等待 不能生产
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


public class ProConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();


        new Thread(()->{
            for(int i = 0;i < 5;i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();


        new Thread(()->{
            for(int i = 0;i < 5;i++) {
                try {
                    shareData.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();

    }
}
