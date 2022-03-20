package com.functionalinterface;

public interface IInterfaceConcepts {

    /*
            Rule 1: java: interface abstract methods cannot have body
            Rule 2: If body is given then there must be any access modifier like static or default
            Rule 3: Static methods of interface can not be overridden in children classes
            Rule 4: Default methods can be overridden - Default methods are used for backward compatibility also

    */
    final String s = "I2";

    int iMethod();      // abstract method

    static void method1()
    {
        System.out.println(s);
    }

    default String method2(String x)
    {
        return s + x;
    }
}

class C2 implements IInterfaceConcepts
{

    @Override
    public int iMethod() {
        return 0;
    }

    // @Override  --  Rule 3: Static methods of interface can not be overridden in children classes
    public void method1() {

    }

    @Override
    public String method2(String x) {
        return x;
    }
}

class C3 implements IInterfaceConcepts {

    @Override
    public int iMethod() {
        return 0;
    }
}

class TestInterface
{
    public static void main(String[] args)
    {
        IInterfaceConcepts.method1();
        IInterfaceConcepts objC2 = new C2();
        IInterfaceConcepts objC3 = new C3();

        System.out.println(objC2.method2("Hello"));
        System.out.println(objC3.method2("World"));
    }
}

