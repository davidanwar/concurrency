package com.agripedia;

public class ThreadCommunicationTest {
    private static String message = null;
    public static void main(String[] args) throws InterruptedException {

//        var thread1 = new Thread(() -> {
//            while (message == null) {
//
//            }
//            System.out.println(message);
//        });
//
//        var thread2 = new Thread(() -> {
//            message = "David Anwar";
//        });
//
//        thread2.start();
//        thread1.start();
//
//        thread2.join();
//        thread1.join();


        ///////////////// Wait and Notify //////////////////
        final var lock = new Object();
        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // menunggu notify
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "David Anwar";
                lock.notify();
            }

        });

        thread1.start(); // pastikan threan yang wait jalan terlebih dahulu
        thread2.start();

        thread1.join();
        thread2.join();


    }
}
