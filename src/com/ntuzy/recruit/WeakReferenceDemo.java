package com.ntuzy.recruit;

import java.lang.ref.WeakReference;

/**
 * @Author IamZY
 * @create 2020/1/30 19:36
 */
public class WeakReferenceDemo {
    public static void main(String[] args){

        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());



    }

}
