package com.patterns.tutorialspoint.others.mvc;

/*
        Step 2
        Create View.
*/
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
