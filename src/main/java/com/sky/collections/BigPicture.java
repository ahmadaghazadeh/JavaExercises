package com.sky.collections;

import java.util.*;

public class BigPicture {
    public static void main(String[] args) {
        Collection<String> list = new HashSet<>();
        String[] names={"Arad","Ahmad","Ali","David"};

        list.addAll(Arrays.asList(names));
        System.out.println(list);

        System.out.println("Ahmad is in the list? "+list.contains("Ahmad"));

        List<String>  strings= new ArrayList<>(15);
        Collections.fill(strings, "Ahmad");
        System.out.println(strings);

        var copyOfStrings = Collections.nCopies(4, "Ahmad");
        System.out.println(copyOfStrings);

        Collections.addAll(strings,names);

        Collections.copy(strings,copyOfStrings);
        System.out.println(strings);

        var newCards=List.copyOf(strings);
        System.out.println(newCards);
       }
}
