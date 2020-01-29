package com.ntuzy.recruit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author IamZY
 * @create 2020/1/29 15:16
 */
class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("*********** come in callable");
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        t1.start();
        FutureTask<Integer> task = new FutureTask(new MyThread2());
        Thread t1 = new Thread(task,"AAA");
        Thread t2 = new Thread(task,"AAA");
        t1.start();
        t2.start();

        int ret01 = 100;
        int ret02 = task.get();
        System.out.println("*******result " + (ret01 + ret02));
    }
}
