package com.ntuzy.recruit;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @Author IamZY
 * @create 2020/1/30 19:24
 */
public class WeakHashMapDemo {
    public static void main(String[] args){
//        myHashmap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {

        WeakHashMap<Integer,String> map = new WeakHashMap<>();

        Integer key = new Integer(2);
        String value = "WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);


    }

    private static void myHashmap() {

        HashMap<Integer,String> map = new HashMap<>();

        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);

    }
}
