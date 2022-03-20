package com.methodreference;

/*
    https://mkyong.com/java8/java-8-method-references-double-colon-operator/
*/

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/*
    https://mkyong.com/java8/java-8-method-references-double-colon-operator/

    https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

*/
/*
    There are four kinds of method references:

    -        Reference to a static method ClassName::staticMethodName
    -        Reference to an instance method of a particular object Object::instanceMethodName
    -        Reference to an instance method of an arbitrary object of a particular type ContainingType::methodName–
    -        Reference to a constructor ClassName::new
 */
public class MethodReferenceMkyong {

    static List<String> list = Arrays.asList("A", "B", "C");

    public static void main(String[] args) {





        /*
                3 WAYS TO PRINT
        */

        // METHOD - 1
        List<String> list2 = Arrays.asList("node", "java", "python", "ruby");
        list2.forEach(new Consumer<String>() {       // anonymous class
            @Override
            public void accept(String str) {
                System.out.print(str + ", ");
            }
        });

        // METHOD - 2
        list2.forEach(str -> System.out.print(str + "; ")); // lambda

        // METHOD - 3
        list2.forEach(System.out::print);          // method references


        type1StaticMethodReferenceDemo();
        type2InstanceParticularMethodReferenceDemo();
        type3InstanceArbitraryMethodDemo();
        type4ConstructorReferenceDemo();
    }

    /*
            TYPE 1 OF 4 (Reference to a static method ClassName::staticMethodName):
            ===========================================================================
                Lambda expression   :  (args) -> ClassName.staticMethodName(args)
                Method Reference    :  ClassName::staticMethodName
    */
    public static void type1StaticMethodReferenceDemo() {
     /*
                3 WAYS TO CALL METHOD
        */

        // METHOD - 1
        // anonymous class
        list.forEach(new Consumer<String>() {
            // @Override - Not Necessary
            public void accept(String x) {
                SimplePrinter.print(x);
            }
        });

        list.forEach(new Consumer<String>() {
            // @Override
            public void accept(String s) {
                SimplePrinter.print("accept() >>>> " + s);
            }
        }.andThen(new Consumer<String>() {
            // @Override
            public void accept(String s) {
                System.out.println("I am andThen");
            }
        }));

        // METHOD - 2
        // lambda expression
        list.forEach(x -> SimplePrinter.print(x));

        // METHOD - 3
        // method reference
        list.forEach(SimplePrinter::print);


        List<String> list = Arrays.asList("1", "2", "3");

        // anonymous class
        List<Integer> collect1 = list.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\n");
        collect1.forEach(System.out::print);

        // lambda expression
        List<Integer> collect2 = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        System.out.println("\n");
        collect2.forEach(System.out::print);

        // method reference
        List<Integer> collect3 = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("\n");
        collect3.forEach(System.out::print);

        /*  =====================================================================================================================================
            BiFunction
                Below example joins two Integer and returns a String.
                It passes a method reference static method IntegerUtils::join as an argument into another method that accepts a BiFunction.
            =====================================================================================================================================
        */
        // anonymous class
        String BiFunctionResult1 = playTwoArgument(111, 2222, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return IntegerUtils.join(a, b);
            }
        });                                                                   // 3

        System.out.println("\n BiFunctionResult1 = " + BiFunctionResult1);

        // lambda
        String BiFunctionResult2 = playTwoArgument(111, 2222, (a, b) -> IntegerUtils.join(a, b));  // 3

        System.out.println("\n BiFunctionResult2 = " + BiFunctionResult2);


        // method reference
        String BiFunctionResult3 = playTwoArgument(111, 2222, IntegerUtils::join);                 // 3

        System.out.println("\n BiFunctionResult3 = " + BiFunctionResult3);


    }


    public static void type2InstanceParticularMethodReferenceDemo() {

        System.out.println("------------ type2InstanceParticularMethodReferenceDemo() OUTPUT BELOW::: ------");

          /*
            TYPE 2 OF 4 (Reference to an instance method of a particular object Object::instanceMethodName):
            ====================================================================================================
                Lambda expression       :   (args) -> object.instanceMethodName(args)
                Method Reference        :   object::instanceMethodName

          */


        /*
            This example sorts a list of Employee by salary. We can reference to an instance method compareBySalary of a particular object ComparatorProvider.
        */

        List<Employee> list = Arrays.asList(
                new Employee("mkyong", 38, BigDecimal.valueOf(3800)),
                new Employee("zilap", 5, BigDecimal.valueOf(100)),
                new Employee("ali", 25, BigDecimal.valueOf(2500)),
                new Employee("shapata", 99, BigDecimal.valueOf(9999)));

        // anonymous class
                /*
                    list.sort(new Comparator<Employee>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                            return provider.compareBySalary(o1, o2);
                        }
                    });
                */

        ComparatorProvider provider = new ComparatorProvider();

        // lambda
        // list.sort((o1, o2) -> provider.compareBySalary(o1, o2));

        // method reference
        list.sort(provider::compareBySalary);

        list.forEach(x -> System.out.println(x.toString()));

    }

    public static void type3InstanceArbitraryMethodDemo() {
          /*
            TYPE 3 OF 4 (Reference to an instance method of an arbitrary object of a particular type ContainingType::methodName–):
            =======================================================================================================================

            */
        /*
           Reference to an instance method of an arbitrary object of a particular type.

           The statement is a bit confusing, need little explanation, see below samples:

                Lambda expression :
                =====================

                        // arg0 is the first argument
                        (arg0, rest_of_args) -> arg0.methodName(rest_of_args)

                        // example, assume a and b are String
                        (a, b) -> a.compareToIgnoreCase(b)

                Method Reference :
                ====================

                        // first argument type
                        arg0_Type::methodName

                        // arg0 is type of ClassName
                        ClassName::methodName

                        // example, a is type of String
                        String::compareToIgnoreCase

          For (String a, String b), where a and b are arbitrary names, and String is its arbitrary type.
          This example uses method reference to an instance method compareToIgnoreCase of an arbitrary object
          a (first argument) of a particular type String.

                          String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
                          Arrays.sort(stringArray, String::compareToIgnoreCase);

            We passed a method reference String::compareToIgnoreCase as a comparator for Arrays.sort.

             explanation:
            ==============

            Review the Arrays.sort method signature:

            public static <T> void sort(T[] a, Comparator<? super T> c)
            {
            }

            In the above example, Arrays.sort expects a Comparator<String>.
            The Comparator is a function interface, its abstract method compare matches BiFunction<String, String, Integer>,
            it takes two arguments of String and returns an int.

             Comparator.java
            ===================

            @FunctionalInterface
            public interface Comparator<T>
            {
                int compare(T o1, T o2);  // this matches BiFunction<String, String, Integer>
            }

                            Review the BiFunction method signature:
                            ========================================
                                BiFunction.java

                                @FunctionalInterface
                                public interface BiFunction<T, U, R> {
                                      R apply(T t, U u);
                                }

          The below lambda provides implementation for BiFunction<String,String,Integer>,
          so the Arrays.sort accepts the below lambda expression as valid syntax.

                (String a, String b) -> a.compareToIgnoreCase(b) // return int

                // a is type of String  method reference
                String::compareToIgnoreCase
        */



        System.out.println("------------ type3InstanceArbitraryMethodDemo() OUTPUT BELOW::: ------");

        // lambda
                int result = playOneArgument("mkyong", x -> x.length());   // 6

        // method reference
                int result2 = playOneArgument("mkyong", String::length);   // 6

        // lambda
                Boolean result3 = playTwoArgument("mkyong", "y", (a, b) -> a.contains(b)); // true

        // method reference
                Boolean result4 = playTwoArgument("mkyong", "y", String::contains);        // true

        // lambda
                Boolean result5 = playTwoArgument("mkyong", "1", (a, b) -> a.startsWith(b)); // false

        // method reference
                Boolean result6 = playTwoArgument("mkyong", "y", String::startsWith);        // false

        System.out.println("result6 = " + result6);

        System.out.println(playTwoArgument("XYZA", "XYZAC", String::equalsIgnoreCase) );

        System.out.println(playTwoArgument("mkyong", "MKYONG", String::equalsIgnoreCase) );
        System.out.println(playTwoArgument("mkyong", "MKYONG", String::equals) );
        System.out.println(playTwoArgument("mkyong", "mkyong", String::equals) );

        // =====================================================================================================
        // Let us see another example, custom object.

        Invoice obj = new Invoice("A001", BigDecimal.valueOf(1.99), 3);

        InvoiceCalculator formula = new InvoiceCalculator();

        /*
            1 - The first argument is a type of InvoiceCalculator.
            2 - So, we can reference to an instance method ( normal() or promotion() ) of an
                arbitrary object [ f ]  of a particular type InvoiceCalculator.

                    (f, o) -> f.normal(o))          CAN BE REPLACED WITH     InvoiceCalculator::normal
                    (f, o) -> f.promotion(o))       CAN BE REPLACED WITH     InvoiceCalculator::promotion
        */


        // lambda
                BigDecimal resultCust = calculate(formula, obj, (f, o) -> f.normal(o));         // 5.97

        // Lambda can be replaced with method reference - [   METHOD REFERENCE   ]
                BigDecimal resultCust2 = calculate(formula, obj, InvoiceCalculator::normal);         // 5.97

        // lambda
                BigDecimal resultCust3 = calculate(formula, obj, (f, o) -> f.promotion(o));     // 5.37

        // Lambda can be replaced with method reference - [   METHOD REFERENCE   ]
                BigDecimal resultCust4 = calculate(formula, obj, InvoiceCalculator::promotion); // 5.37

       System.out.println("resultCust = " + resultCust);
        System.out.println("resultCust2 = " + resultCust2);
        System.out.println("resultCust3 = " + resultCust3);
        System.out.println("resultCust4 = " + resultCust4);}

    public static void type4ConstructorReferenceDemo() {

            /*
                    TYPE 4 OF 4 (Reference to a constructor ClassName::new):
                    =========================================================

                          Lambda expression   :   (args) -> new ClassName(args)
                          Method Reference    :   ClassName::new
            */

            // Reference to a default constructor.

                    // lambda
                            Supplier<Map> obj1 = () -> new HashMap();   // default HashMap() constructor
                            Map map1 = obj1.get();

                    // method reference
                            Supplier<Map> obj2 = HashMap::new;
                            Map map2 = obj2.get();

                    // lambda
                            Supplier<Invoice> obj3 = () -> new Invoice(); // default Invoice() constructor
                            Invoice invoice1 = obj3.get();

                    // method reference
                            Supplier<Invoice> obj4 = Invoice::new; // default contructor must exist
                            Invoice invoice2 = obj4.get();


            // Reference to a constructor which accepts an argument – Invoice(BigDecimal unitPrice)

                    List<BigDecimal> bigDeclist = Arrays.asList(
                            BigDecimal.valueOf(9.99),
                            BigDecimal.valueOf(2.99),
                            BigDecimal.valueOf(8.99));

                    // lambda
                    // List<Invoice> invoices = fakeInvoice(bigDeclist, (price) -> new Invoice(price));

                    // method reference
                    List<Invoice> invoices = fakeInvoice(bigDeclist, Invoice::new);  // Invoice::new --> refers to ---> public Invoice(BigDecimal unitPrice)

                    invoices.forEach(System.out::println);

    }

    static List<Invoice> fakeInvoice(List<BigDecimal> list, Function<BigDecimal, Invoice> func) {
        List<Invoice> result = new ArrayList<>();

        for (BigDecimal amount : list) {
            result.add(func.apply(amount));
        }
        return result;
    }

    private static <R> R playTwoArgument(Integer i1, Integer i2, BiFunction<Integer, Integer, R> func) {
        return func.apply(i1, i2);
    }

    static <R> R playOneArgument(String s1, Function<String, R> func) {
        return func.apply(s1);
    }

    static Boolean playTwoArgument(String s1, String s2, BiPredicate<String, String> func) {

        return func.test(s1, s2);

//        func.test(
//
//            System.out.println("s1" + s1);
//           return false;
//        );

    }


    static BigDecimal calculate(InvoiceCalculator formula, Invoice s1, BiFunction<InvoiceCalculator, Invoice, BigDecimal> myFunc) {
        return myFunc.apply(formula, s1);
    }

}

class SimplePrinter {
    public static void print(String str) {
        System.out.println("I am Simple Printer class = " + str);
    }
}

class IntegerUtils {

    public static String join(Integer a, Integer b) {
        return String.valueOf(a + b);
    }

}

class InvoiceCalculator {

    public BigDecimal normal(Invoice obj) {
        return obj.getUnitPrice().multiply(BigDecimal.valueOf(obj.qty));
    }

    public BigDecimal promotion(Invoice obj) {
        return obj.getUnitPrice()
                .multiply(BigDecimal.valueOf(obj.qty))
                .multiply(BigDecimal.valueOf(0.9))
                .setScale(2, RoundingMode.HALF_UP);
    }
}

class Invoice {

    String no;
    BigDecimal unitPrice;
    Integer qty;


    public Invoice() {
    }

    public Invoice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Invoice(String no, BigDecimal unitPrice, Integer qty) {
        this.no = no;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    // generated by IDE, setters, gettes, constructor, toString

    @Override
    public String toString() {
        return "Invoice{" +
                "no='" + no + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}

class ComparatorProvider {

    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

}


