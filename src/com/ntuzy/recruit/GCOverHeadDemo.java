package com.ntuzy.recruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author IamZY
 * @create 2020/1/31 11:32
 */
public class GCOverHeadDemo {
    public static void main(String[] args) {


        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("*******************i= " + i);
            e.printStackTrace();
            throw e;
        }


    }
}
