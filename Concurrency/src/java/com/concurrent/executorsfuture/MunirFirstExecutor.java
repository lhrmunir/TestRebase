package com.concurrent.executorsfuture;

import java.util.concurrent.*;

public class MunirFirstExecutor {

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        MunirFirstExecutor mfe = new MunirFirstExecutor();

        System.out.println("My first executor service");

        ExecutorService exs =  Executors.newScheduledThreadPool(10);

        Future<Integer> fu_int_1 = exs.submit(() -> mfe.getInt_1());
        Future<Integer> fu_int_2 = exs.submit(() -> mfe.getInt_2());

        System.out.println("------> RESULT = " + (fu_int_1.get() + fu_int_2.get()));

        exs.shutdown();
    }

    public int getInt_1() {
        return 5;
    }

    public int getInt_2() {
        return 22;
    }
}
