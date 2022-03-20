package com.concurrent.completablefuture;

import java.util.concurrent.*;

/*
        https://blog.softwaremill.com/synchronous-or-asynchronous-and-why-wrestle-with-wrappers-2c5667eb7acf
        https://www.callicoder.com/java-callable-and-future-tutorial/
        https://www.callicoder.com/java-8-completablefuture-tutorial/

        https://stackoverflow.com/questions/37863100/create-completablefuture-from-a-sync-method-call
*/
public class CFCallsSynchronousMethod
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        System.out.println("-------------------- DEMONSTRATION OF CALLING SYNCHRONOUS METHOD WITH COMPLETABLEFUTURE ---------------------");

        CompletableFuture<String> future = new CompletableFuture<>();

        future.complete("23");

        future.thenAccept(System.out::println)
                .thenAccept(v -> System.out.println("done"));

        CompletableFuture awakeTooMuchCodeFuture = awakeTooMuchCode(5);
        System.out.println("awakeTooMuchCodeFuture result =======>>>> " + awakeTooMuchCodeFuture.get());

        CompletableFuture awakeShortFuture = awakeShort(5);
        System.out.println("\nawakeShortFuture awakeShortFuture.isDone() =======>>>> " + awakeShortFuture.isDone());
        System.out.println("awakeShortFuture result =======>>>> " + awakeShortFuture.get());
        System.out.println("awakeShortFuture awakeShortFuture.isDone() =======>>>> " + awakeShortFuture.isDone());



        awakeTooMuchCodeFuture.thenAccept(System.out::println)
                .thenAccept(v -> System.out.println("awakeTooMuchCodeFuture is DONE"));

        awakeShortFuture.thenAccept(System.out::println)
                .thenAccept(v -> System.out.println("awakeShortFuture is DONE"));





        /*
              Since you want that your CompletableFuture is completed with a result of some method call,
              and you do not want to complete that CompletableFuture yourself - then you need not CompletableFuture -
              any Future implementation would be ok. For example,
        */

//    T function(parameters) {
//        return new T();
//    }
        String reslt_1 = sleepStr("Pakistan"); // SYNCHRONOUS CALL
        Future<String> f = ForkJoinPool.commonPool().submit(() -> sleepStr("India"));  // ASYNCHRONOUS CALL WITH FUTURE
        String reslt_2 = f.get();

        System.out.println("\nLength of Pakistan = " + reslt_1);
        System.out.println("\nLenght of India = " + reslt_2);
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            System.out.println("\ninside sleep() : Just awake after " + seconds + " Seconds...");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        /*
         try {
            Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
            }
         */
    } // public static void sleep(int seconds)

    public static CompletableFuture awakeTooMuchCode(int seconds) {

        // CompletableFuture<String> future = new CompletableFuture<>();

        CompletableFuture<Integer> futureInt = new CompletableFuture<>();

        final CompletableFuture<String> future = new CompletableFuture<>();
        final String parameters = "hello";

        String result = "";
        try {
            result = sleepStr(parameters); /* SYNCRONOUS METHOD IS CALLED. GOAL ACHIEVED   */
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        future.complete(result);

        return future;
    }

    public static CompletableFuture awakeShort(int seconds) {

        final String parameters = "hello";
         return CompletableFuture.supplyAsync(() -> sleepStr(parameters));
    }

    public static String sleepStr(String anyString) {

        // TimeUnit.SECONDS.sleep(4);
        sleep(4);
        System.out.println("inside sleepStr(...) : Just awake after 4 Seconds...");


        return "from sleepStr : anyString.lenght() = " + anyString.length();
    } // public static void sleep(int seconds)

}
