package com.ralphapress2019code.chapter11;
import java.util.Optional;
public class Sect4_Ex2 
{
    public static void main(String[] args)
    {        
        try {
           String s = null;
            String opt = Optional.ofNullable(s)
                                 .orElseThrow(() -> 
                                     new Exception("Null Optional"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}