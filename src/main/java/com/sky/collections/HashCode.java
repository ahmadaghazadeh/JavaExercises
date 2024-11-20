package com.sky.collections;

import java.util.*;

public class HashCode {
    private static final String emailData= """
            Mickey mouse, mckmouse@gmail.com
            Mickey mouse, mckmouse1@gmail.com
            Minnie mouse, mckmouse2@gmail.com
            """;

    public static void main(String[] args) {

        String aHello="Hello";
        String bHello="He".concat("llo");
        String cHello="H"+"ello";
        String dHello="hello";

        List<String> list = new ArrayList<String>(Arrays.asList(aHello,bHello,cHello,dHello));

        list.forEach(s-> System.out.println(s+" "+s.hashCode()));

        Set<String> mySet = new HashSet<String>(list);

        System.out.println(mySet);
        System.out.println(mySet.size());

        List<String> emails=new ArrayList<>();
        Scanner scanner = new Scanner(emailData);
        while (scanner.hasNext()){
            var text = scanner.next();
            System.out.println(text);
            emails.add(text);
        }
        System.out.println(emails);

    }
}


