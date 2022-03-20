package com.patterns.tutorialspoint.behavioral.mediator;

/*
Step 3
        Use the User object to show communications between them.
*/

public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
