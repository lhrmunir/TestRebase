package com.concurrent.readfilesconcurrently.files.src.main.java.johnny.java.concurrency.readfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;

// https://www.java-success.com/10-%E2%99%A6-executorservice-vs-forkjoin-future-vs-completablefuture-interview-qa/

public class CompleteableFutureExample
{
    // https://www.java-success.com/10-%E2%99%A6-executorservice-vs-forkjoin-future-vs-completablefuture-interview-qa/
    static class Recursive<I> {
        public I func;
    }

    static Function<Integer, Double> factorial = x -> {
        FutureExample.Recursive<IntToDoubleFunction> recursive = new FutureExample.Recursive<IntToDoubleFunction>();
        recursive.func = n -> (n == 0) ? 1 : n * recursive.func.applyAsDouble(n - 1);

        return recursive.func.applyAsDouble(x);
    };

    public static void main(String[] args) throws Exception
    {
        System.out.println("CallableExample.java ::: Result:");
        // create tasks
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new CallableTask("test" + (i + 1) + ".txt"));
        }

        // create threads for each task
        ThreadPoolExecutor newFixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        final int nthFactorial = 25;

        // create threads for each task
        CompletableFuture<Double> factorialCalcStage = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " factorial task is called");
            Double factorialResult = factorial.apply(nthFactorial);
            return factorialResult;
        }, newFixedThreadPool);

         /*
        https://www.java-success.com/10-%E2%99%A6-executorservice-vs-forkjoin-future-vs-completablefuture-interview-qa/

                if you need result
                        f.thenApply(result -> isDone(result));      // sync callback
                        f.thenApplyAsync(result -> isDone(result)); // async callback


        */

/*
            BEST:
                    https://www.callicoder.com/java-8-completablefuture-tutorial/


        List<String> webPageLinks = Arrays.asList(...)	// A list of 100 web page links

        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
                .map(webPageLink -> downloadWebPage(webPageLink))
                .collect(Collectors.toList());


        // Create a combined Future using allOf()
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
        );
*/

//        List<Callable<String>> cfTasks = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            cfTasks.add(new CallableTask("test" + (i + 1) + ".txt"));
//        }
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fileNames.add("test" + (i + 1) + ".txt");
        }


//      ß








        ExecutorService exec = Executors.newFixedThreadPool(2);
        List<Future<String>> results = exec.invokeAll(tasks);
        exec.shutdown();

        // collect results
        System.out.println("Result:");
        String content = "";
        try {
            for (Future<String> future : results) {
                content += future.get() + System.lineSeparator();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

//    private static CompletableFuture<String> loadFile(String fileName) {
//
//        CallableTask task = new CallableTask(fileName);
//
//        return CompletableFuture.supplyAsync(() -> {
//            // Code to download and return the web page's content
//        });
//    }


    public static void main_for_CallableExampleThreadPoolExecutor_java(String[] args)
    {
        System.out.println("CallableExampleThreadPoolExecutor.java ::: Result:");
        List<Future<String>> list = new ArrayList<Future<String>>();

        // create threads for each task
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            CallableTask task = new CallableTask("test" + i + ".txt");

            Future<String> future = executor.submit(task);
            list.add(future);
        }
        executor.shutdown();

        // collect results
        System.out.println("Result:");
        String content = "";
        try {
            for (Future<String> future : list) {
                content += future.get() + System.lineSeparator();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }
}
