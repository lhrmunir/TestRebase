package com.ralphapress2019code.chapter1;

import java.util.Locale;

public class TestStringProcessor
{
    public static void main(String[] args)
    {
        NamedStringProcessor namedSP = new NamedStringProcessor();

        StringProcessor anonSP = new StringProcessor() {
            @Override 
            public String process(String x)
            {
                return x.toUpperCase();
            }
        };

        StringProcessor lowerSP = new StringProcessor() {
            @Override
            public String process(String x) { return x.toLowerCase(); }
        };

        System.out.println(namedSP.process("hello"));
        System.out.println(anonSP.process("hello"));
        System.out.println(lowerSP.process("WORlD"));
    }
}
