package com.sky.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCollections {
    public static void main(String[] args) {
        String[] names={"1","2","3","4","5","6"};
        List<String> list=new ArrayList<>(Arrays.asList(names));
        List<String> orginal=new ArrayList<>(Arrays.asList(names));

        int subListIndex= Collections.indexOfSubList(list,new ArrayList<>(Arrays.asList("Ali","David")));
        System.out.println(subListIndex);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        System.out.println("Contains = "+Collections.disjoint(list,Arrays.asList("Ali","David")));
        System.out.println("Contains = "+Collections.disjoint(list,Arrays.asList("Ali1","David1")));

        int notFind=Collections.binarySearch(list,"Ali",String::compareTo);
        System.out.println(notFind);

        int foundIndex=Collections.binarySearch(list,"b",String::compareTo);
        System.out.println(foundIndex);

        int withOutSort=list.indexOf("Bahram");
        System.out.println(withOutSort);

        if(Collections.replaceAll(list,"Ahmad","Ahmad2")){
            System.out.println("Replaced Ahmad");
        }else{
            System.out.println("Not Replaced Ahmad2");
        }

        System.out.println("Most repeated element time :" +Collections.frequency(list,"Arad"));
        System.out.println("Last name :" +Collections.max(list,String::compareTo));
        System.out.println("First  name :" +Collections.min(list,String::compareTo));

        Collections.rotate(orginal,-1);
        System.out.println("Rotated "+orginal);

        var copied=new ArrayList<>(Arrays.asList(names));
        for (int i = 0; i < copied.size()/2; i++) {
            Collections.swap(copied,i,copied.size()- 1- i);
        }
        System.out.println("Manual reverse "+copied);
    }
}
