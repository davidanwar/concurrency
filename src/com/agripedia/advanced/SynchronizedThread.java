package com.agripedia.advanced;


public class SynchronizedThread {

    private static int counter1 = 0;
    private static int counter2 = 0;

    private static final Object object1 = new Object();
    private static final Object object2 = new Object();
    public static void  increment1() {
        synchronized (object1) {
            counter1++;
        }
    }
    public static void  increment2() {
        synchronized (object2) {
            counter2++;
        }
    }

    public static void process() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment1();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment2();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter1);
        System.out.println(counter2);

    }
    public static void main(String[] args) throws InterruptedException {
        process();
    }
}
