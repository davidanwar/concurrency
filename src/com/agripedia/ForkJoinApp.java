package com.agripedia;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinApp {
    public static void main(String[] args) {
        var forkJoinPool1 = ForkJoinPool.commonPool(); // memanfaatkan semua core CPU
        var forkJoinPool2 = new ForkJoinPool(5); // hanya menggunakan 5 core CPU
        var executor1 = Executors.newWorkStealingPool();
        var executor2 = Executors.newWorkStealingPool(5);

    }

    public static class SimpleForkJoniTask extends RecursiveAction {

        private List<Integer> integers;

        public SimpleForkJoniTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {

        }
    }
}
