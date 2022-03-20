package com.concept.example;

// https://www.journaldev.com/129/how-to-create-immutable-class-in-java

/*
    What is an immutable class in Java?
    ====================================
    - Immutable objects are instances whose state doesn’t change after it has been initialized.
    - For example, String is an immutable class and once instantiated its value never changes.

    Benefits of Immutable Class in Java
    =====================================
    - An immutable class is good for caching purposes because you don’t have to worry about the value changes.
    - Another benefit of immutable class is that it is inherently thread-safe, so you don’t have to worry about thread safety in case of multi-threaded environment.

    Steps to Create an immutable class in Java?
    ===========================================
        1- Declare the class as "final" so it can’t be extended  i,e. Don’t allow the class to be subclassed.
        2- Make all fields private so that direct access is not allowed.
        3- Don’t provide setter methods for variables.
        4- Make all mutable fields "final" so that its value can be assigned only once.
        5- Initialize all the fields via a constructor performing deep copy.
        6- Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

        To understand points 4 and 5, let’s run the sample Final class that works well and values don’t get altered after instantiation.


                        The strategy for creating an Immutable Class is:
                        Steps:
                        2. Make all fields final and private
                        4. If the instance fields include references to mutable objects, don’t allow those objects to be changed:
                                –  Don’t provide methods that modify the mutable objects.
                                –  Don’t share references to the mutable objects.
                        As an added Task, handle the case where exits is null when passed to the constructor.
                        NOTE: Not all classes documented as “immutable” follow these rules. However, the steps above are the basis of an Immutable Class.
 */
//public class ImmutableClassCreationExample {
//}

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClassCreationExample {

    private final int id;

    private final String name;

    private final HashMap<String,String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
        //return testMap;
        return (HashMap<String, String>) testMap.clone();
    }

    /**
     * Constructor performing Deep Copy
     * @param i
     * @param n
     * @param hm
     */

    public ImmutableClassCreationExample(int i, String n, HashMap<String,String> hm)
    {
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = i;
        this.name = n;
        HashMap<String,String> tempMap = new HashMap<String,String>();
        String key;
        Iterator<String> it = hm.keySet().iterator();

        while(it.hasNext()){
            key = it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap=tempMap;
    }


    /**
     * Constructor performing Shallow Copy
     * @param i
     * @param n
     * @param hm
     */
    /**
                 public FinalClassExample(int i, String n, HashMap<String,String> hm){
                 System.out.println("Performing Shallow Copy for Object initialization");
                 this.id=i;
                 this.name=n;
                 this.testMap=hm;
                 }
     */

    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String,String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;

        ImmutableClassCreationExample ce = new ImmutableClassCreationExample(i,s,h1);

        //Lets see whether its copy by field or reference
        System.out.println(s==ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getTestMap());
        //change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());
    }
}