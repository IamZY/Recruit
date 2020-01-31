package com.ntuzy.recruit;

/**
 * @Author IamZY
 * @create 2020/1/31 11:22
 */
public class StackOverFlowErrorDemo {

    public static void main(String[] args){

        StackOverflowErrorMethod();


    }

    private static void StackOverflowErrorMethod() {
        StackOverflowErrorMethod();
    }

}
