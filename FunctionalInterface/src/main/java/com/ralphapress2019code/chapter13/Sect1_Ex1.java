package com.ralphapress2019code.chapter13;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        Runnable r = () -> System.out.println("RED");
        r.run();               
    }
}