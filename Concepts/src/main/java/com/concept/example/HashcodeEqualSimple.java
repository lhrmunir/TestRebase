package com.concept.example;

/*
    By default, two objects will be the same only if stored in the same memory location.
 */
public class HashcodeEqualSimple {

    public static void main(String[] args){
        String a = "Andrew";
        String b = "Andrew";

        if(a.equals(b)){   //checking the equality of objects using equals() methods
            System.out.println("a & b are equal variables, and their respective hashvalues are:" + " "+ a.hashCode() + " & " + b.hashCode());

        }

        String c = "Maria";
        String d= "Julie";

        if(!c.equals(d)){    //checking  the equality of objects using equals() method
            System.out.println("\nc & d are Un-equal variables, and their respective hashvalues are:" + " "+ c.hashCode() + " & " + d.hashCode());

        }

        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        boolean balanced = income.equals(expenses);

        System.out.println("balanced = " + balanced);
    }

}
