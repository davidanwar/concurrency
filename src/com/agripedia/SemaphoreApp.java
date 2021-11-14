package com.agripedia;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreApp {
    public static void main(String[] args) throws InterruptedException {
        var semaphore = new Semaphore(1); // hanya satu increament yang dibolehkan
        var executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    semaphore.acquire(); // menunggu ketika ada tread lain yang merelease
                    Thread.sleep(1000L);
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
