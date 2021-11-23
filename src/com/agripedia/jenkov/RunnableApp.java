package com.agripedia.jenkov;

public class RunnableApp implements Runnable {

    private boolean stop = false;

    public synchronized boolean isStop() {
        return stop;
    }

    public synchronized void setStop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!isStop()) {
            System.out.println("Thread is running");
        }
    }

}
