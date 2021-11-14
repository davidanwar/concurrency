package com.agripedia;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        var executor = Executors.newSingleThreadExecutor();
//        Callable<String> callable = ()-> {
//            Thread.sleep(3000);
//            return "Hello";
//        };
//        Future<String> future = executor.submit(callable);
//        while (!future.isDone()) {
//            System.out.println("Tunggu sebentar");
//            Thread.sleep(1000);
//        }
//        String value = future.get();
//        System.out.println(value);



        ////////////////////// List FUTURE ////////////////
        var executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) ()-> {
            Thread.sleep(2000);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        var future = executor.invokeAll(callables);
        for (Future<String> stringFuture : future) {
            System.out.println(stringFuture.get());
        }

    }
}
