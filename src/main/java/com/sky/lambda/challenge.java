package com.sky.lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class challenge{
    public static void main(String[] args) {
        Consumer<String> print=new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts=s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> print2= (sentence) ->{
            Arrays.asList(sentence.split(" ")).forEach(word -> System.out.println(word));
        };

        var text="I am Ahmad Ahazadeh.";

        print.accept(text);
        print2.accept(text);

        UnaryOperator<String> everySecondCharLambda= (sentence) ->{
            StringBuilder returnVal=new StringBuilder();
            for (int i = 0; i < sentence.length(); i++) {
                if(i % 2 ==1){
                    returnVal.append(sentence.charAt(i));
                }
            }
            return returnVal.toString();
        };

        var result= everySecondCharLambda.apply("1234567890");
        System.out.println(result);

        System.out.println(calcEverySecondChar(everySecondCharLambda,"1234567890"));

        Supplier<String> iLoveJavaLambda= () -> "I love java";
        System.out.println(iLoveJavaLambda.get());

    }
    public static String calcEverySecondChar(UnaryOperator<String> operator, String sentence){
        return operator.apply(sentence);
    }
}

