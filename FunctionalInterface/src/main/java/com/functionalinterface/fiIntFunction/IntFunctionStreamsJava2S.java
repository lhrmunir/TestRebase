package com.functionalinterface.fiIntFunction;

// http://www.java2s.com/Tutorials/Java_Streams/java.util.stream/Stream/Stream_toArray_IntFunction_generator_example.htm

/*
        Stream toArray(IntFunction generator) example

        Description:
        ============
        Stream toArray(IntFunction<A[]> generator) returns an array containing the elements of this stream,
        using the provided generator function.

        Syntax:
        =======
        toArray has the following syntax.
        <A> A[] toArray(IntFunction<A[]> generator)

        Example:
        ========
        The following example shows how to use toArray.
*/

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.function.IntFunction;
/*

IntFunction represents a function that accepts an int-valued argument and produces a result. This is the int-consuming primitive specialization for Function.

*/
public class IntFunctionStreamsJava2S
{
    public static void main(String[] args)
    {
        /* -------- EXAMPLE : 1 -------- */
        IntFunction<String> i = (x)->Integer.toString(x);

        System.out.println("i.apply(3).length() =========> " + i.apply(393).length());

        /* ------------- EXAMPLE : 2 ----------  */
        List<Employee> persons = Employee.persons();

        Employee[] men = persons.stream()
                .filter(p -> p.getGender() == Gender.MALE)
                .toArray(Employee[]::new);

        System.out.println("After increasing the income: " + men);

        Arrays.stream(men).forEach(System.out::println);
    }
}  /*  -------- END ---- OF ---- public class IntFunctionStreamsJava2S ------------  */

enum Gender
{
    MALE, FEMALE
}

class Employee
{
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public Employee(long id, String name, Gender gender, LocalDate dob,
                    double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public static List<Employee> persons() {
        Employee ken = new Employee(1, "Jame", Gender.MALE, LocalDate.of(1970,
                Month.MAY, 4), 6123.0);
        Employee jeff = new Employee(2, "Jeff", Gender.MALE, LocalDate.of(1971,
                Month.JULY, 5), 7112.0);
        Employee donna = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1972,
                Month.JULY, 9), 8712.0);
        Employee chris = new Employee(4, "Jodd", Gender.MALE, LocalDate.of(1973,
                Month.DECEMBER, 6), 1823.0);
        Employee laynie = new Employee(5, "Janey", Gender.FEMALE, LocalDate.of(1974,
                Month.DECEMBER, 3), 1234.0);
        Employee lee = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1975, Month.MAY,
                8), 2412.0);

        // Create a list of persons
        List<Employee> persons = Arrays.asList(ken, jeff, donna, chris, laynie, lee);

        return persons;
    }

    @Override
    public String toString() {
        String str = String.format("(%s, %s, %s, %s, %.2f)", id, name, gender, dob, income);
        return str;
    }
}   /*  -------- END ---- OF ---- class Employee ------------  */

