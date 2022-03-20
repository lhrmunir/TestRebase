package com.concurrent.synchronization.racecondition;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count = count +  1;
        System.out.println(count);
    }
}
