package com.sky.lambda;

import java.util.function.*;

public class MehtodRefrence {
    public static void main(String[] args) {

        calculator(Integer::sum,1,2);
        calculator(Double::sum,1.1,2.5);
        calculator((a,b) -> a+b,1,2);

        Supplier<PlainOld> refrence1=() -> new PlainOld();
        Supplier<PlainOld> refrence2= PlainOld::new;

        refrence1.get();
        refrence2.get();

        calculator((s1, s2) -> s1+s2,"Ahmad","Aghazadeh");
        calculator((s1, s2) -> s1.concat(s2),"Ahmad","Aghazadeh");
        calculator(String::concat,"Ahmad","Aghazadeh");

        BinaryOperator<String> unbandedReciver= (a,b) -> a.concat(b);
        BinaryOperator<String> unbandedReciver1= String::concat;

        BiFunction<String,String,String> b2= (a,b) -> a.concat(b);
        BiFunction<String,String,String> b3= String::concat;

        var xx= "Hello".transform((String::toUpperCase));
        var xx1= "Hello".transform(s -> s.toUpperCase());

        Function<String,Boolean> checkString = (s) -> s.isEmpty();
        Function<String,Boolean> checkString1 = String::isEmpty;

    }

    public static <T> void calculator(BinaryOperator<T> calculator, T value1, T value2) {
        var result= calculator.apply(value1, value2);
        System.out.println(result);
    }
}
class PlainOld{
    private static int last_id=1;

    private int id;

    public PlainOld() {
        this.id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld object: id="+id);
    }
}