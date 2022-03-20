package com.ralphapress2019code.chapter2.incorrect;
public class Sect5_Ex3 
{
    public static void main(String[] args)
    {
        int z = 2;
        FIVoid LambdaLocalBad = x -> {

            System.out.println(x + z);
        };
    }
}
