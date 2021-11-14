package com.agripedia;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownApp {
    public static void main(String[] args) throws InterruptedException {
        var count = new CountDownLatch(5); // thread yang lain akan menungu sampai count jadi nol
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(()-> {
                try {
                    System.out.println("Task Start");
                    Thread.sleep(2000L);
                    System.out.println("Task Finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count.countDown(); // setiap thread menurunkan count
                }
            });
        }

        executor.execute(() -> {
            try {
                count.await();
                // ini dieksekusi sampai count 05
                System.out.println("Finished All Task");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);



    }
}
