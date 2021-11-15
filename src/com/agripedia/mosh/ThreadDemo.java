package com.agripedia.mosh;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        var status = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(status.getTotalBytes());


    }
    public static void show() {


    }
}
