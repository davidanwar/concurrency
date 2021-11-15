package com.agripedia.mosh;

public class DownloadFileTask implements Runnable {
    DownloadStatus status;
    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            status.incrementTotalBytes();
        }
        System.out.println("Download Complete : " + Thread.currentThread().getName());
    }
}
