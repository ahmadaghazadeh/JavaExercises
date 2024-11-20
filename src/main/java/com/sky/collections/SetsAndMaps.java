package com.sky.collections;

import java.util.HashSet;
import java.util.Set;

public class SetsAndMaps {

    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        Set<String> set2 = new HashSet<String>();
        set2.add("A1");
        set2.add("B");
        set2.add("C1");
        set2.add("D");
        set2.add("E1");

        Set<String> set3 = new HashSet<String>();
        set3.addAll(set);
        set3.addAll(set2);
        System.out.println("A ∪ B ="+set3);
    }
}
