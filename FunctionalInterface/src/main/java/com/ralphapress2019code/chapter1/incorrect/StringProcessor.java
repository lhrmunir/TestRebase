package com.ralphapress2019code.chapter1.incorrect;
// @FunctionalInterface    //ERROR: Not a functional interface.
                        //       Contains more than one abstract 
                        //       method.
public interface StringProcessor       
{
       String process(String x);
       String process2(String x);
}
