package com.agripedia;

import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class ReactiveStreamApp {
    public static void main(String[] args) throws InterruptedException {
        // untuk buffer yang diset sendiri. Nilai default 256
        var publisher2 = new SubmissionPublisher<String>(Executors.newFixedThreadPool(10), 50);
        var processor = new HellProcessor();


        var publisher = new SubmissionPublisher<String>();
        var subscriber = new PrintSubscriber();
        publisher.subscribe(subscriber);
        publisher2.subscribe(processor);
        processor.subscribe(subscriber);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(()-> {
            for (int i = 0; i < 100; i++) {
                publisher.submit("David- " + i);
                System.out.println("Send David- " + i);
            }

        });

        var executor2 = Executors.newFixedThreadPool(10);
        executor.execute(()-> {
            for (int i = 0; i < 100; i++) {
                publisher2.submit("David- " + i);
                System.out.println("Send David- " + i);
            }

        });


        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(100L * 1000L);
    }



    public static class PrintSubscriber implements Flow.Subscriber<String> {

        private Flow.Subscription subscription;
        private String name;
        private Long sleep;

        public PrintSubscriber() {
        }

        public PrintSubscriber(Flow.Subscription subscription, String name, Long sleep) {
            this.subscription = subscription;
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1L);
        }

        @Override
        public void onNext(String s) {
            try {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " : " + name + " : "+ s);
                this.subscription.request(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " DONE");
        }
    }

    public static class HellProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1L);
        }

        @Override
        public void onNext(String s) {
            var value = "Hello " + s;
            submit(value);
            this.subscription.request(1L);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            close();
        }
    }
}
