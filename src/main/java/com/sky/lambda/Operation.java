package com.sky.lambda;

@FunctionalInterface
public interface Operation<T> {

    T operate(T value, T value2);
}
