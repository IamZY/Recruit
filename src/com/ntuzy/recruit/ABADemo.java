package com.ntuzy.recruit;

import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author IamZY
 * @create 2020/1/22 16:50
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        System.out.println("=========================以下是ABA问题的产生===============================");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();


        new Thread(() -> {
            // 保证上面t1线程完成ABA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=========================以下是ABA问题的解决===============================");

        new Thread(() -> {

            int stamp = atomicStampedReference.getStamp();

            System.out.println(Thread.currentThread().getName() + "\t" + stamp);

            // 暂停1秒钟t3线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), 2);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), 3);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicStampedReference.getStamp());

        }, "t3").start();


        new Thread(() -> {

            int stamp = atomicStampedReference.getStamp();

            System.out.println(Thread.currentThread().getName() + "\t" + stamp);

            // 暂停1秒钟t4线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, 1);
            int newStamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + result + "\t实际版本号" + newStamp);

            System.out.println(Thread.currentThread().getName() + "\t" + result + "\t实际值" + atomicStampedReference.getReference());

        }, "t4").start();


    }
}
