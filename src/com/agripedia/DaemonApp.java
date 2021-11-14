package com.agripedia;

public class DaemonApp {

    public static void main(String[] args) throws InterruptedException {

        var thread = new Thread(()-> {
            try {
                Thread.sleep(3000);
                System.out.println("Runnable");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true); // thread akan berhenti jika program selesai
        thread.start();

    }
}
