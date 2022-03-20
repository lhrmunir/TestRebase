package com.ralphapress2019code.chapter4;
import java.util.function.Function;
public class Sect3b_Ex1 
{
    public static void main(String[] args)
    {
        Function<Boolean, Integer> fbi = x -> x==true? 1:0;
        Function<String, Boolean>  fsb = x -> Boolean.parseBoolean(x);

        System.out.println(fbi.compose(fsb)    // Function<String, Boolean>
                              .apply("true")); // Function<Boolean, Integer>

        /* ---------------------------------------------------------------------------------- */

        Function<Boolean, Integer> fbiNew = (x) -> {

            int ixx = x == true ? 1 : 0;

            System.out.println("inside fbiNew...." + ixx);

            return ixx * 6;

        };


        Function<String, Boolean>  fsbNew = x -> Boolean.parseBoolean(x);

        // Function<String, Boolean>  fsbNew = x -> Boolean.parseBoolean(x);

        System.out.println(fbiNew.compose(fsbNew)    // Function<String, Boolean>
                .apply("true")); // Function<Boolean, Integer>

    }
}
