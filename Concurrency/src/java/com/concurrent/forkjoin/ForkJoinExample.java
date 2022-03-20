package com.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample
{
    static final int size = 10000;

    public static void main(String[] args)
    {
        double[] numbers = new double[size];

        // generate random numbers
        for (int i = 0; i < size; i++)
        {
            numbers[i] = Math.random();
        }

        Counter counter = new Counter(numbers, 0, numbers.length, x->x > 0.5);

        ForkJoinPool pool = new ForkJoinPool();

        /* -------- https://stackoverflow.com/questions/17876144/fork-join-related-join-vs-get-vs-invoke ------------  */
        /*
        invoke
        ======
                Commences performing this task, awaits its completion if necessary,
                and returns its result, or throws an (unchecked) RuntimeException
                or Error if the underlying computation did so.
         */
        System.out.println("pool.invoke(counter) = " + pool.invoke(counter)); // Performs the given task, returning its result upon completion.

        /*
        join
        =====
                This method is inherited from Future, this method is analogous to join. From the javadoc for join:

                Returns the result of the computation when it is done. This method differs from get() in that abnormal completion
                results in RuntimeException or Error, not ExecutionException, and that interrupts of the calling thread do not cause
                the method to abruptly return by throwing InterruptedException.
         */
        System.out.println("counter.join() = " + counter.join()); // output: 500305

        try {
            /*
                get
                ===
                    Waits if necessary for the computation to complete, and then retrieves its result.
             */
            System.out.println("counter.get() = " + counter.get()); // output: 500305
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
