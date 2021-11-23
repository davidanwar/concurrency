package com.agripedia.advanced;


class Process {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running in produce method");
            wait();
            System.out.println("Again in produce method");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(2000);
            System.out.println("Consume method is executed");
            notify();
            // wait() direalease setalah code setelah notify() dieksekusi semuanya di dalama synchronized block
        }
    }
}
public class WaitNotify {
    public static void main(String[] args) {
        Process process = new Process();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
