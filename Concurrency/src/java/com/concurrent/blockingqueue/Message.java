package com.concurrent.blockingqueue;

public class Message {
    private String msg;

    public Message(String msg){
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
