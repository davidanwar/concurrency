package com.agripedia;

import java.util.concurrent.*;

public class ConcurrentMapApp {
    public static void main(String[] args) throws InterruptedException {
        var countDown = new CountDownLatch(100);
        var map = new ConcurrentHashMap<Integer, String>();
        var executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000L);
                    map.putIfAbsent(index, "Data - " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDown.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDown.await();
                map.forEach(((integer, s) -> System.out.println(integer + " : " + s)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
