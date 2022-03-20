package com.ralphapress2019code.chapter2;
@FunctionalInterface
public interface TwoArgsProcessor<X> {
    X process(X arg1, X arg2);
}