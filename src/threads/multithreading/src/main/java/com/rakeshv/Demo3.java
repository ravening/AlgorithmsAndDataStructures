package threads.multithreading.src.main.java.com.rakeshv;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Demo3
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new TestThread(), 0, 5, TimeUnit.SECONDS);
    }
}

class TestThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Current time is " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}