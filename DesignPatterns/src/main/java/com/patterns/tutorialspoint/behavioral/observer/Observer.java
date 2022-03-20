package com.patterns.tutorialspoint.behavioral.observer;

/*
Step 2
        Create Observer class.
*/

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
