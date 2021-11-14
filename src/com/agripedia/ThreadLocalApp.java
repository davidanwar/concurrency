package com.agripedia;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalApp {
    public static void main(String[] args) throws InterruptedException {
        var random = new Random();
        var userService = new UserServiceApp();
        var executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    userService.setUser("User : " + index); // nilainya hanya untuk thread yang sama
                    Thread.sleep(1000 + random.nextInt(3000));
                    userService.doAction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
