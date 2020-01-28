package com.ntuzy.recruit;

import java.rmi.activation.ActivationGroup_Stub;
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写操作
 * 原子+独占  中间整个过程不允许被分割
 *
 * @Author IamZY
 * @create 2020/1/28 11:54
 */
class MyCache { // 资源类

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {

        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入 " + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }


    }


    public void get(String key) {

        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取... ");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结果" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }


    }


}


public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, i + "").start();
        }


    }

}
