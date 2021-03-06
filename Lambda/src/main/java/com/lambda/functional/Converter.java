package com.lambda.functional;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
