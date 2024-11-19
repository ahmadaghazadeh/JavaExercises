package com.sky.lambda;

import java.util.function.Function;

public class ChainingLambdas {
    public static void main(String[] args) {
        String name="Ahmad";
        Function<String,String> uCase= String::toUpperCase;

        Function<String,String> lastName= s -> s.concat(" Aghazadeh");
        Function<String,String> uCaseAndLastName= uCase.andThen(lastName);
        System.out.println(uCaseAndLastName.apply(name));

        System.out.println(uCase.compose(lastName).apply(name));
        System.out.println(uCase.compose(lastName).andThen(lastName));
        System.out.println(uCase.compose(lastName).andThen(lastName).apply(name));
    }

}
