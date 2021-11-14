package com.agripedia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueApp {
    public static void main(String[] args) throws InterruptedException {

        ///////////////// Array Blocking Queue //////////////
//        var queue = new ArrayBlockingQueue<String>(5);
//        var executor = Executors.newFixedThreadPool(20);
//
//        for (int i = 0; i < 10; i++) {
//            executor.execute(() -> {
//                try {
//                    queue.put("Data");
//                    System.out.println("Finish Put Data");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        executor.execute(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(2000L);
//                    var result = queue.take();
//                    System.out.println("Receive Data : " + result);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });

//        executor.awaitTermination(1, TimeUnit.DAYS);



        ///////////////// Linked Blocking Queue //////////////
        var queue = new LinkedBlockingQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Finish Put Data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000L);
                    var result = queue.take();
                    System.out.println("Receive Data : " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
