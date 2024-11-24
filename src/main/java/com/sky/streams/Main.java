package com.sky.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<String> bingoPool =new ArrayList<String>();
         
        int start= 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start+15); i++) {
                bingoPool.add(""+ c + i);
                //System.out.println(""+ c + i);
            }
            start+=15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(50));

        var tempStream= bingoPool.stream()
                .limit(15)
                .filter(s-> s.indexOf("G")==0 || s.indexOf("O")==0)
                .map(s-> s.charAt(0)+"-"+s.substring(1))
                .sorted();

        tempStream.forEach(s-> System.out.print(s.toLowerCase()+ " "));

        System.out.println("-".repeat(50));

    }
}
