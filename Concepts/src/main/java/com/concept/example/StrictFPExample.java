package com.concept.example;

public class StrictFPExample {

    public strictfp double sum()
    {
        double operand1 = 12e+05;
        double operand2 = 9e+10;
        return (operand1+operand2);
    }
    public static strictfp void main(String[] args)
    {
        StrictFPExample sumObject = new StrictFPExample();
        System.out.println(sumObject.sum());
    }
}
