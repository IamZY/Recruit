package com.ntuzy.recruit;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author IamZY
 * @create 2020/1/30 19:38
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("===============================================");

        o1 = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
