package com.agripedia.jenkov;

import java.util.concurrent.TimeUnit;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            go();
        };
        RunnableApp app = new RunnableApp();
        Thread thread = new Thread(runnable, "Thread 1");
        Thread thread1 = new Thread(new RunnableApp());
        thread1.start();
        //thread.start();
        TimeUnit.SECONDS.sleep(2);
        app.setStop();
    }

    public static void go() {
        System.out.println("Inside go ...");
    }
}
