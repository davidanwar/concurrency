package com.agripedia;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    Long value = 0L;

    final private Lock lock = new ReentrantLock();

    void increment() {
        try {
            lock.lock();
            value++;
        } finally {
            lock.unlock();
        }

    }

    Long getValue() {
        return value;
    }
}
