package thread;

import com.thread.MyRunnable;
import com.thread.MyThread;
import org.junit.Test;

public class ThreadTest {

    @Test
    public void test() {
        // Thread class
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable interface
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
