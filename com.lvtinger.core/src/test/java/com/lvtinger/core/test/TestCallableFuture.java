package com.lvtinger.core.test;

import java.util.concurrent.*;

public class TestCallableFuture {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        System.out.println("start MAIN");
        ExecutorService executorService = Executors.newCachedThreadPool();
        FirstCallable firstCallable = new FirstCallable();
        SecondCallable secondCallable = new SecondCallable();
        Future<Integer> firstFuture = executorService.submit(firstCallable);
        Future<Integer> secondFuture = executorService.submit(secondCallable);
        executorService.shutdown();
        System.out.println(firstFuture.get());
        System.out.println(secondFuture.get());

        System.out.println("end MAIN");
    }

    static class FirstCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("start the FIRST callable");
            System.out.println("the FIRST callable thread id = "+ Thread.currentThread().getId());
            Thread.sleep(3000L);
            System.out.println("end the FIRST callable");
            return new Integer(1);
        }
    }

    static class SecondCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {

            System.out.println("start the SECOND callable");
            System.out.println("the SECOND callable thread id = "+ Thread.currentThread().getId());
            Thread.sleep(1000L);
            System.out.println("end the SECOND callable");

            return new Integer(2);
        }
    }
}
