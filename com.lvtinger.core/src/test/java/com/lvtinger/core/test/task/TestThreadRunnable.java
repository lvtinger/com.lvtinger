package com.lvtinger.core.test.task;

import java.util.concurrent.FutureTask;

public class TestThreadRunnable {
    public static void main(String... args) {
        System.out.println("start MAIN");
        System.out.println("get request from tc thread id = " + Thread.currentThread().getId());
        FirstRunnable firstRunnable = new FirstRunnable();
        SecondRunnable secondRunnable = new SecondRunnable();
        new Thread(firstRunnable).start();
        new Thread(secondRunnable).start();
        System.out.println("end MAIN");

        FutureTask<Integer> futureTask;
    }

    static class FirstRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("start the FIRST runnable...");
            try {
                System.out.println("get request from the FIRST runnable thread id = " + Thread.currentThread().getId());
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end the FIRST runnable...");
        }
    }

    static class SecondRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("start the SECOND runnable...");
            try {
                System.out.println("get request from the SECOND runnable thread id = " + Thread.currentThread().getId());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end the SECOND runnable...");
        }
    }
}
