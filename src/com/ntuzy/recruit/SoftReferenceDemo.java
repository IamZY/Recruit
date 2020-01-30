package com.ntuzy.recruit;

import java.lang.ref.SoftReference;

/**
 * @Author IamZY
 * @create 2020/1/30 17:27
 */
public class SoftReferenceDemo {

    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference softReference = new SoftReference(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();


        System.out.println(o1);
        System.out.println(softReference.get());
    }


    public static void main(String[] args){
        softRef_Memory_Enough();
    }
}
