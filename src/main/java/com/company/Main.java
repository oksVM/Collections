package com.company;

import com.company.collection.list.ListIterator;
import com.company.collection.list.impl.LinkedList;
import com.company.map.HashMap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(14);
        list.add(15);
        list.delete(1);
        list.add(17);
        list.delete(2);
        list.add(1239);
        list.delete(1);
        list.add(6);
        System.out.println(list);

        System.out.println("====FROM_HEAD====");
        for (Integer i: list){
            System.out.println(i);
       }

        System.out.println("====FROM_TAIL====");
        ListIterator<Integer> iterator =  list.iterator();
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println("====HASHMAP====");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(133,"1");
        map.put(2,"12");
        map.put(333,"13");
        map.put(4,"111");
        map.put(533, "-12-");
        map.put(6,"1");
        map.put(733,"12");
        map.put(8,"13");
        map.put(933,"111");
        map.put(10, "-12-");
        map.put(1133,"1");
        map.put(125,"12");
        map.put(13,"13");
        map.put(1433,"111");
        map.put(15, "-12-");
        map.put(165,"1");
        map.put(17,"12");
        map.put(18,"13");
        map.put(1955,"111");
        map.put(20, "-12-");
        System.out.println(map.delete(1111));
        System.out.println(map.delete(20));
        System.out.println(map.size());
        System.out.println(map);
        //System.out.println(map.get(1));
        System.out.println(map.get(121));

    }
}
