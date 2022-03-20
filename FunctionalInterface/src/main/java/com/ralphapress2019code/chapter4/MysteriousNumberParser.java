package com.ralphapress2019code.chapter4;

import java.util.function.Function;
import java.util.ArrayList;

public class MysteriousNumberParser
{
    private static <Y extends Number> Y parse(String x, Function<String, Y> f)
    {
        System.out.println("inside parser(...)");

        return f.apply(x);
    }

    public static void main(String[] args)
    {
        System.out.println("1 inside main(...)");

        ArrayList< Function<String,? extends Number> > list = new ArrayList<>();

        System.out.println("2 inside main(...)");

        /*
                MYSTERIOUS : HOW ELEMENTS ARE BEING ADDED IN ARRAYLIST FROM ARRAY WHICH IS DECLARED BELOW?
         */
        list.add(om -> Byte.parseByte(om));   // Byte.parseByte(om) >>> JUST function is added in list
        list.add(tp -> Short.parseShort(tp));
        list.add(zx -> Integer.parseInt(zx));
        list.add(xl -> Long.parseLong(xl));
        list.add(x2 -> Float.parseFloat(x2));
        list.add(tt -> Double.parseDouble(tt));

//        list.add(x -> Byte.parseByte(x));
//        list.add(x -> Short.parseShort(x));
//        list.add(x -> Integer.parseInt(x));
//        list.add(x -> Long.parseLong(x));
//        list.add(x -> Float.parseFloat(x));
//        list.add(x -> Double.parseDouble(x));

        String[] arrNumbers = {"10", "99", "88", "40", "50", "60"};
        Number[] results = new Number[arrNumbers.length];

        for (int i=0; i < arrNumbers.length; ++i)
        {
            results[i] = parse(arrNumbers[i], list.get(i));
            System.out.println("inside for loop : " + results[i]);
        }
    }
}
