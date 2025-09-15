package com.neueda.sample.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map= new HashMap<>();
        map.put(4,"User1");
        map.put(2,"User7");
        map.put(1,"User6");
        map.put(5,"User3");
        map.put(null,null);
        map.put(null,"Test User");

        System.out.println(map);
        System.out.println("Element with Key 3"+map.get(3));
        System.out.println(map.remove(4));
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());

    }
}
