package com.sky.streams;

import com.sky.lambda.challenge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

//
//        System.out.println("-".repeat(50));
////        Stream.iterate(1, i-> i<=100,i -> i +1 )
////                .peek(s-> System.out.println("peek:"+s))
////                .dropWhile(x-> x<=10)
////                .peek(s-> System.out.println("dropWhile:"+s))
////                .takeWhile(x-> x<=15)
////                .peek(s-> System.out.println("takeWhile:"+s))
////                .mapToInt(x-> x+1)
////                .boxed()
////                .map("%2d"::formatted)
////                .forEach(System.out::println);

//        System.out.println("-".repeat(50));
//         var stream= Stream.iterate(1, i-> i<=100,i -> i +1 )
//        .dropWhile(x-> x<=10)
//        .takeWhile(x-> x<=15)
//        .mapToInt(x-> x);
//
//         System.out.println(stream.summaryStatistics());

//        System.out.println("-".repeat(50));
//        var stream= Stream.iterate(1, i-> i<=100,i -> i +1 )
//                .collect(Collectors.groupingBy(x-> x%5));
//
//        stream.entrySet().forEach(System.out::println);
//

//        System.out.println("-".repeat(50));
//        var stream= "This is a string please find max char repeated this sentence."
//                .chars()
//                .mapToObj("%2c"::formatted)
//                .collect(Collectors.groupingBy(x->x,Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue));
//
//        stream.forEach(stringLongEntry -> System.out.println(stringLongEntry.getKey()+" "+stringLongEntry.getValue()));





    }

    private static int getCounter(){
        return counter++;
    }

    private record Statistic(char c, int count){}
}
