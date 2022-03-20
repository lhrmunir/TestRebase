package com.ralphapress2019code.chapter4;
import java.util.function.Function;
public class Sect1_Ex1 
{
    public static void main(String[] args)
    {
        Function<String, Integer> f;
        f = x -> Integer.parseInt(x);
        
        Integer i = f.apply("100");
        System.out.println(i);

        // -------------------------------------------------------------------
        Function<Float, String> fTest;

        fTest = x -> Float.toString(x);

        String ix = fTest.apply(Float.parseFloat("200F"));
        System.out.println(ix);

        // ---------------------------------------------------------------------

        Function<String, Boolean> fsb = x -> Boolean.parseBoolean(x);

        System.out.println(
                fsb.andThen(x -> x==true? 1:0) // Function<Boolean, Integer>
                        .apply("true"));            // Function<String, Boolean>

        // ---------------------------------------------------------------------
        Function<String, Boolean> fsb2 = x -> Boolean.parseBoolean(x);

        System.out.println(
                fsb2.andThen(x -> x==true? "it is true... " : "it is false...") // Function<Boolean, Integer>
                        .apply("false"));            // Function<String, Boolean>

        // ---------------------------------------------------------------------
    }
}
