package com.generic.bounded;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
    Bounded Types
    ===============
    In general, the type parameter can accept any data types (except primitive types).

    However, if we want to use generics for some specific types (such as accept data of number types) only,
    then we can use bounded types.  In the case of bound types, we use the extends keyword. For example,

    <T extends A>
    This means T can only accept data that are subtypes of A.

    notice the expression : <T extends Number>

    Here, GenericsClass is created with bounded type.
    This means GenericsClass can only work with data types that are children of Number (Integer, Double, and so on).
 */
/*
    https://www.programiz.com/java-programming/generics
 */
class GenericsClass <T extends Number> {

    private T myFoo;

    public GenericsClass(T data) {
        this.myFoo = data;
    }

    public void display() {

        Type myClass = myFoo.getClass();
        String myClassName = myClass.toString();
        String myClassTypeName = myClass.getTypeName();
        // String className3 = ((ParameterizedType) mySuperclass).getRawType().toString();

        System.out.println("This is a bounded type generics class. myFoo = " + myFoo);
        System.out.println("This is a bounded type generics class. myClassName = " + myClassName);
        System.out.println("This is a bounded type generics class. myClassTypeName = " + myClassTypeName);



        Type mySuperclass = myFoo.getClass().getGenericSuperclass();
        // Type tType = ((ParameterizedType)mySuperclass).getActualTypeArguments()[0];

        String mySuperClassName = mySuperclass.toString();
        String mySuperTypeName = mySuperclass.getTypeName();
        // String className3 = ((ParameterizedType) mySuperclass).getRawType().toString();

        System.out.println("This is a bounded type generics class. myFoo = " + myFoo);
        System.out.println("This is a bounded type generics class. mySuperClassName = " + mySuperClassName);
        System.out.println("This is a bounded type generics class. mySuperTypeName = " + mySuperTypeName);
        // System.out.println("This is a bounded type generics class. className3 = " + className3);

//Parse it as String
        // String className = tType.toString().split(" ")[1];

//        System.out.println("This is a bounded type generics class." + className);
//        System.out.printf( "This is a bounded type generics class. >>> %s ", className );
    }
}

class BoundedExtendDemo1 {
    public static void main(String[] args) {

        /*
            create an object of GenericsClass

            COMPILE TIME ERROR:
            ===================
            java: type argument java.lang.String is not within bounds of type-variable T
         */
        // GenericsClass<String> obj = new GenericsClass<>();

        GenericsClass<Integer> intObj = new GenericsClass<>(52);
        intObj.display();

        GenericsClass<Long> longObj = new GenericsClass<>(22L);
        longObj.display();

        Double b = 2.0931;

        GenericsClass<Double> doubleObj = new GenericsClass<>(b);
        doubleObj.display();

    }
}
