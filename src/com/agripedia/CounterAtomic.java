package com.agripedia;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

    AtomicLong value = new AtomicLong(0L);

    void setValue() {
        value.incrementAndGet();
    }

    Long getValue() {
        return value.get();
    }

}
