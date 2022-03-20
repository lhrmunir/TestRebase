package com.ralphapress2019code.chapter13;
import java.util.concurrent.CompletableFuture;
public class Sect4_Ex3 
{
    public static void main(String[] args)
    {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync( () -> {
            System.out.println("EXECUTING THE FUTURE");
            return 4;
        });
        
        System.out.println("NOT EXECUTED YET");
        System.out.println(cf.join());
    }
}