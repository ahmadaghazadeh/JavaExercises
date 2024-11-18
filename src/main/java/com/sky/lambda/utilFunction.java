package com.sky.lambda;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class utilFunction {

    public static void main(String[] args) {
        int result = calculator((a, b) -> {
            return a + b;
        }, 1, 2);
        var result2 = calculator((a, b) -> a / b, 1.0, 2.5);
        var result3 = calculator((a, b) -> a + " " + b, "Ahmad", "Aghazadeh");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


        var coords = Arrays.asList(
                new double[]{47.12, -98.55},
                new double[]{47.12, -98.55},
                new double[]{47.12, -98.55}
        );

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        coords.forEach(s-> processPoint((lat, lon) ->
                System.out.printf("Lat: %.3f, long: %.3f",lat,lon),s[0],s[1]));



    }

    public static <T> T calculator(BinaryOperator<T> function, T Value, T value2) {
        return function.apply(Value, value2);
    }

    public static <T> void processPoint(BiConsumer<T,T> consumer, T Value, T value2) {
        consumer.accept(Value, value2);
    }

}
