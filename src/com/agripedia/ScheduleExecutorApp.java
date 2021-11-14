package com.agripedia;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorApp {
    public static void main(String[] args) throws InterruptedException {

        ////////// Schedule Delay Job//////////
//        var executor = Executors.newScheduledThreadPool(10);
//        var future = executor.schedule(() -> System.out.println("Hello"), 5, TimeUnit.SECONDS);
//        System.out.println(future.getDelay(TimeUnit.SECONDS));
//        executor.awaitTermination(1, TimeUnit.DAYS);

        ////////// Schedule Periodik//////////

        var executor = Executors.newScheduledThreadPool(10);
        var future = executor.scheduleAtFixedRate(() -> System.out.println("Hello"), 3, 2, TimeUnit.SECONDS);
        System.out.println(future.getDelay(TimeUnit.SECONDS));
        executor.awaitTermination(1, TimeUnit.DAYS);


    }
}
