package com.zmeev.concurrency;

public class TestThreadCreationDirectly {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + this.getName());
        }
    }
}
