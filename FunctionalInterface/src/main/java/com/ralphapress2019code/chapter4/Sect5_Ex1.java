package com.ralphapress2019code.chapter4;

import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.DoubleFunction;

public class Sect5_Ex1 
{
    public static void main(String[] args)
    {
        IntFunction<String> fi = x -> (new Integer(x)).toString();
        DoubleFunction<Boolean> fd = x -> x > 5.0? true : false;
        LongFunction<Integer> fl = x -> (int)x;

        System.out.println(fi.apply(5));
        System.out.println(fd.apply(4.5));
        System.out.println(fl.apply(20L));

        // ------------------------------------------------------------

        IntFunction<String> fTclass = x -> {

            x = x * 500;
            Tclass tcls = new Tclass();

            String test1 = tcls.test(x); // (new Integer(x)).toString();

            return test1 ;

        };

        System.out.println("VALUE FROM OTHER CLASS = " + fTclass.apply(5));

        // --------------------------------------------------------

        IntFunction<Tclass> tclassO = x -> {

            Tclass tcls1 = new Tclass();

            tcls1.setiValue("FGFDJHGKJDHFG KDFJHGKDHGKJDFH DSHJGKFDHGKJFH");

            return tcls1;

        };

        System.out.println("Class Name = " + tclassO.apply(5));
        System.out.println(tclassO.apply(5).getiValue());

    }

    static class Tclass {

        public String getiValue() {
            return iValue;
        }

        public void setiValue(String iValue) {
            this.iValue = iValue;
        }

        String iValue;

        public String test(int ix) {

            return "value from Tclass : value received from Functional Interface = " +  ix;
        }

    }
}


