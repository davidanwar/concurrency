package com.agripedia;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerApp {

    public static void main(String[] args) throws InterruptedException {
        var exchanger = new Exchanger<String>();
        var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                System.out.println("Kirim data thread1");
                String result = exchanger.exchange("First");
                System.out.println("Terima data dari thread2 " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Kirim data thread2");
                String result = exchanger.exchange("Second");
                System.out.println("Terima data dari thread1 " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);

    }
}
