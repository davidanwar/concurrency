package com.agripedia.india;

import java.util.concurrent.TimeUnit;

public class FirstThread {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
//        Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Inside main ...");
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside run ...");
        go();
    }

    public void go() {
        System.out.println("Inside go ...");
        more();
    }

    public void more () {
        System.out.println("Inside more ...");
    }
}
