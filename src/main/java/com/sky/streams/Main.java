package com.sky.streams;

import com.sky.lambda.challenge;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static int counter=1;
    public static void main(String[] args) {
//         List<String> bingoPool =new ArrayList<String>();
//
//        int start= 1;
//        for (char c : "BINGO".toCharArray()) {
//            for (int i = start; i < (start+15); i++) {
//                bingoPool.add(""+ c + i);
//                //System.out.println(""+ c + i);
//            }
//            start+=15;
//        }
//
//        Collections.shuffle(bingoPool);
//        for (int i = 0; i < 15; i++) {
//            System.out.println(bingoPool.get(i));
//        }
//        System.out.println("-".repeat(50));
//
//        var tempStream= bingoPool.stream()
//                .limit(15)
//                .filter(s-> s.indexOf("G")==0 || s.indexOf("O")==0)
//                .map(s-> s.charAt(0)+"-"+s.substring(1))
//                .sorted();
//
//        tempStream.forEach(s-> System.out.print(s.toLowerCase()+ " "));

//        System.out.println("-".repeat(50));
//        String[] strings={"one","two","three"};
//        var firstStream= Arrays.stream(strings)
//                .sorted(Collections.reverseOrder());
//        //        .forEach(System.out::println);
//
//        System.out.println("-".repeat(50));
//        var secondStream= Stream.of("six","seven","eight","nine")
//                .map(String::toUpperCase);
//        //        .forEach(System.out::println);
//
//        Stream.concat(secondStream, firstStream)
//                .forEach(System.out::println);
//
//        int seed=1;
//        var streamB=Stream.iterate(seed,i -> i<=15, i-> i+1)
//                .map(i-> "B"+i);
//        streamB.forEach(System.out::println);
//
//
//
//        var streamO=Stream.generate(() -> {return counter++;})
//                .limit(15)
//                .map(i -> "O"+i);
//
//        var streamO1=Stream.generate(Main::getCounter)
//                .limit(15)
//                .map(i -> "O"+i);
//
//        streamO1.forEach(System.out::println);
//        streamO.forEach(System.out::println);
//
//        System.out.println("-".repeat(50));
//        Stream.generate(()-> new Random().nextInt(1,15))
//                .limit(15)
//                .map(i -> "O"+i)
//                .sorted()
//                .forEach(System.out::println);


        System.out.println("-".repeat(50));
        Stream.iterate(1, i-> i<=100,i -> i +1 )
                .dropWhile(x-> x<=50)
                .takeWhile(x-> x<=65)
                .forEach(System.out::println);
    }

    private static int getCounter(){
        return counter++;
    }
}
