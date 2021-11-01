package com.zmeev.concurrency.threadCoordination.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {
    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation calculation = new ComplexCalculation();
        BigInteger result = calculation.calculateResult(new BigInteger("2"), new BigInteger("10"),
                new BigInteger("3"), new BigInteger("4"));
        System.out.println(result.toString());
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        List<Thread> threads = new ArrayList<>();
        threads.add(new PowerCalculatingThread(base1, power1));
        threads.add(new PowerCalculatingThread(base2, power2));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (Thread thread : threads) {
            PowerCalculatingThread powerCalculatingThread = (PowerCalculatingThread) thread;
            result = result.add(powerCalculatingThread.getResult());
        }
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            BigInteger tempResult = base;

            for (BigInteger i = BigInteger.ONE; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)) {
                tempResult = tempResult.multiply(base);
            }
            result = tempResult;
        }

        public BigInteger getResult() { return result; }
    }
}
