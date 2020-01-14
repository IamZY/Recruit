package com.ntuzy.recruit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author IamZY
 * @create 2020/1/14 17:08
 */

class MyData {
    volatile int number = 0;

    public void addTo60() {
        number = 60;
    }

//    public /*synchronized*/ void addPP() {

    public synchronized void addPP() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void add() {
        // i++
        atomicInteger.getAndIncrement();
    }


}

/**
 * 验证volatile
 */
public class VolatileDemo {

    public void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in ... ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + " update the number " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + " mission is over");
    }


    public static void main(String[] args) {  // main是一切方法的云翔入口


        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    myData.addPP();
                    myData.add();
                }
            }, "" + i).start();
        }

        // main + gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(myData.atomicInteger);

    }

}
