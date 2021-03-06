package com.patterns.tutorialspoint.others.mvc;

/*
https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm

        MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

        Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

        View - View represents the visualization of the data that model contains.

        Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

        Implementation
        We are going to create a Student object acting as a model.StudentView will be a view class which can print student details on console and StudentController is the controller class responsible to store data in Student object and update view StudentView accordingly.

        MVCPatternDemo, our demo class, will use StudentController to demonstrate use of MVC pattern.
        == === ====== =================================================================================================

        Step 1
        Create Model.
*/

public class Student {
    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}