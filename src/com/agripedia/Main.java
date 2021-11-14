package com.agripedia;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
//        String thread = Thread.currentThread().getName();
//        System.out.println(thread);
//
//        Runnable runnable = () -> {
//            System.out.println("Hello from thread: " + Thread.currentThread().getId());
//        };
//        var core = new Thread(runnable);
//        core.start();
//        System.out.println("Program Selesai");

        ///////////////////// THREAD SLEEP //////////////////////
//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(2_000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread Sleep: " + Thread.currentThread().getId());
//        };
//        var core = new Thread(runnable);
//        core.start();
//        System.out.println("Program Selesai");
//        try {
//            Thread.sleep(3_000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ///////////////////// THREAD JOIN //////////////////////

//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(2_000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread Sleep: " + Thread.currentThread().getId());
//        };
//        var thread = new Thread(runnable);
//        thread.start();
//        System.out.println("Menunggu Thread ");
//        try {
//            thread.join(); // blocking until thread finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Program Selesai");


        ///////////////////// THREAD INTERRUPT //////////////////////

//        Runnable runnable = () -> {
//            for (int i = 0; i < 10; i++) {
//                //if (Thread.interrupted())
//                System.out.println("Runnable : " + i);
//                try {
//                    Thread.sleep(1_000L);
//                } catch (InterruptedException e) {
//                    return;
//                }
//            }
//
//        };
//        var thread = new Thread(runnable);
//        thread.start();
//        Thread.sleep(5_000L);
//        thread.interrupt();
//        System.out.println("Menunggu Thread ");
//        thread.join();
//        System.out.println("Program Selesai");


        ///////////////////// THREAD STATE //////////////////////

        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });
        thread.setName("CPU 1");
        System.out.println(thread.getState());
        thread.start();
        thread.join();
        System.out.println(thread.getState());


    }
}
