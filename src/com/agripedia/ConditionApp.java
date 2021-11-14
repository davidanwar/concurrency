package com.agripedia;

import java.util.concurrent.locks.ReentrantLock;

public class ConditionApp {
    static String message;
    public static void main(String[] args) throws InterruptedException {

        var lock = new ReentrantLock();
        var condition = lock.newCondition();

        var thread1 = new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        var thread2 = new Thread(() ->{
            try {
                lock.lock();
                Thread.sleep(2000L);
                message = "David anwar";
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
