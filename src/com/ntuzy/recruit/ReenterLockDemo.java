package com.ntuzy.recruit;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author IamZY
 * @create 2020/1/28 10:52
 */

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t" + "invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t" + "##################invoked sendSMS()");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t" + "invoked get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t" + "##################invoked set()");
    }


}


public class ReenterLockDemo {
    public static void main(String[] args){
        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();

    }
}
