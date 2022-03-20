package com.ralphapress2019code.chapter13;
public class Sect1_Ex2 
{
    public static void main(String[] args)
    {
        Runnable r = () -> System.out.println("RED");
        (new Thread(r)).start();    
    }
}