package com.patterns.tutorialspoint.behavioral.mediator;

/*

Step 1
        Create mediator class.
*/

        import java.util.Date;

public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}