package com.concurrent.concurrencythreadlocal.inheritable;

public class ChildThread extends Thread {
    public void run(){
        // child data
        System.out.println("Child Thread Value: " + ParentThread.itl_p.get());
    }
}
