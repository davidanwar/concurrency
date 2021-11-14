package com.agripedia;

public class RaceCondition {
    public static void main(String[] args) {
        var counter = new Counter();
        var counterAtomic = new CounterAtomic(); // pengganti synchronus
        Runnable runnable = ()-> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
