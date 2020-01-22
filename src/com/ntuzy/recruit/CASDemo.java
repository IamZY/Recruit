package com.ntuzy.recruit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compare and swap
 * @Author IamZY
 * @create 2020/1/22 15:37
 */
public class CASDemo {

    public static void main(String[] args){

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019) + "--" + atomicInteger.get());// true -- 2019

        System.out.println(atomicInteger.compareAndSet(5,2024) + "--" + atomicInteger.get()); // false -- 2019

        atomicInteger.getAndIncrement();

    }



}
