package com.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/*
        https://blog.softwaremill.com/synchronous-or-asynchronous-and-why-wrestle-with-wrappers-2c5667eb7acf
        https://www.callicoder.com/java-callable-and-future-tutorial/
        https://www.callicoder.com/java-8-completablefuture-tutorial/
*/

public class CFCallicoderExamples {

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

        // The get() method blocks until the Future is complete. So, the above call will block forever because the Future is never completed.
        //String result = completableFuture.get();

        completableFuture.complete("Future's Result");
        String result = completableFuture.get();

        System.out.print("this is result = " + result);

        System.out.println(getResult(1));
    }

    // public static Future getResult(int seconds) throws ExecutionException, InterruptedException {
    public static String getResult(int seconds) throws ExecutionException, InterruptedException {
        // Run a task specified by a Runnable Object asynchronously.
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // Simulate a long-running Job
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println("I'll run in a separate thread than the main thread.");
            }
        });

        // Block and wait for the future to complete
        String strResult = String.valueOf(future.get());

        return strResult;
    }
}
