package com.agripedia.india;

public class ThreadPriorityApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAccess());
        t1.setName("EmailThread");
        t2.setName("DataThread");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t2.join();
        System.out.println(Thread.currentThread().getName());

    }
}

class EmailCampaign implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class DataAccess implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
