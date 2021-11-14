package com.agripedia;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();
//        }

        ///////////////////// Join Thread ////////////////////
//        Thread thread = new Thread(new DownloadFileTask());
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("File is ready to be scanned...");


        //////////////////// Race Condition /////////////////////
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();
        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalByte())
                .reduce(Integer::sum);

        System.out.println(totalBytes);
    }
}
