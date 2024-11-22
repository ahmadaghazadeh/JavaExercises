package com.sky.collections;

import java.util.*;

public class SetView {
    public static void main(String[] args) {
        var p1=new Person("Ahmad",42,914);
        var p2=new Person("Arad",7,914);
        var p3=new Person("Abbas",40,914);
        var p4=new Person("Bahram",25,914);
        var p5=new Person("Amir",39,914);
        var p11=new Person("Ahmad",44,914);

        Map<String, Person> map=new HashMap<>();
        System.out.println(map.put(p1.getName(),p1));
        System.out.println(map.put(p2.getName(),p2));
        System.out.println(map.put(p3.getName(),p3));
        System.out.println(map.put(p4.getName(),p4));
        System.out.println(map.put(p5.getName(),p5));
        System.out.println(map.put(p11.getName(),p11));
        System.out.println(map);
        System.out.println("-".repeat(50));
        Set<String> keyView=map.keySet();

        keyView.retainAll(List.of(p1.getName(),p2.getName()));
        System.out.println(keyView);
        System.out.println(map);
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        var valuesView=map.values();
        System.out.println(valuesView);



//        Set<String> copyOfMap=new TreeSet<>(map.keySet());
//        copyOfMap.retainAll(List.of(p1.getName(),p2.getName()));
//        System.out.println(copyOfMap);
//        System.out.println(map);
        System.out.println("-".repeat(50));
        map.put(p11.getName()+"="+p11.getAge(),p11);
        map.forEach((k,v) -> System.out.println(k+","+v));

        HashSet<Person> findDuplicateSet=new HashSet<>(valuesView);
        if(findDuplicateSet.size()<map.keySet().size()){
            System.out.println("Duplicate values are in my Map");
        }

        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));

        var nodeSet=map.entrySet();
        for (var entry : nodeSet) {
            if(!entry.getKey().equals(entry.getValue().getName()))
            {
                System.out.println("Key doesn't match name "+entry.getKey()+":"+entry.getValue());
            }
        }

    }
}
