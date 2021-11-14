package com.agripedia;

public class SynchronizedCounter {

    Long value = 0L;

    public synchronized void increment() {
        value++;
    }

    Long getValue() {
        return value;
    }
}
