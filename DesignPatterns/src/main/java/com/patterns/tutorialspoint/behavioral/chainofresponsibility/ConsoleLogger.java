package com.patterns.tutorialspoint.behavioral.chainofresponsibility;

/*
        Step 2:
        ========
        Create concrete classes extending the logger.
*/

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}