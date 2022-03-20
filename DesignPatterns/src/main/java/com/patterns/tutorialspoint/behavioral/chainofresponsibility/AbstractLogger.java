package com.patterns.tutorialspoint.behavioral.chainofresponsibility;

/*
        https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm

        As the name suggests, the chain of responsibility pattern creates a chain of receiver objects for a request.
        This pattern decouples sender and receiver of a request based on type of request. This pattern comes under behavioral patterns.

        In this pattern, normally each receiver contains reference to another receiver.
        If one object cannot handle the request then it passes the same to the next receiver and so on.

        Implementation:
        ==================
        We have created an abstract class AbstractLogger with a level of logging. Then we have created three types of loggers extending the AbstractLogger. Each logger checks the level of message to its level and print accordingly otherwise does not print and pass the message to its next logger.

        Step 1:
        ==========
        Create an abstract logger class.
*/

public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //next element in chain or responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}