package com.agripedia.advanced;

import com.agripedia.jenkov.RunnableApp;


class DaemonWorker implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is Daemon Worker");
        }
    }
}

class NormalWorker implements Runnable {

    @Override
    public void run() {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is Normal Worker");

    }
}

public class ThreadApp {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DaemonWorker());
        Thread thread2 = new Thread(new NormalWorker());
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
    }
}
