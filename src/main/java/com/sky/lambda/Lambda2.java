package com.sky.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda2 {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>(List.of(
                "alpha", "bravp", "charlie", "delta"));

        for (String s: list) {
            System.out.println(s);
        }

        list.forEach(s-> System.out.println(s));

        list.forEach(System.out::println);

        list.forEach(string -> {
            var char1= string.charAt(0);
            System.out.println("First char: "+char1);
        });

        int result= calculator((a, b) -> { return a + b;}, 1,2);
        var result2=calculator((a, b) -> a / b, 1.0,2.5);
        var result3=calculator((a, b) -> a + " " + b, "Ahmad","Aghazadeh");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

        list.removeIf(s-> s.equalsIgnoreCase("ALPHA"));
        list.forEach(System.out::println);

        list.replaceAll(s-> s.charAt(0)+"-"+ s.toUpperCase());
        list.forEach(System.out::println);

        String[] emptyStrings=new String[10];
        Arrays.fill(emptyStrings, "A");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> (i+1)+". ");
        System.out.println(Arrays.toString(emptyStrings));
    }

    public static <T> T calculator(Operation<T> function, T Value, T value2){
        return function.operate(Value, value2);
    }
}
