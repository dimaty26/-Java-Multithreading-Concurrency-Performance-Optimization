package com.zmeev.concurrency.threadCreation;

public class TestThreadCreationWithException {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Internal Error");
            }
        });

        thread.setName("Misbehaving thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("An exception occurred in thread " + t.getName()
                + " the error is " + e.getMessage());
            }
        });
        thread.start();
    }
}
