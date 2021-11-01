package com.zmeev.concurrency.advancedLocking;

import java.util.Random;

public class PricesUpdater extends Thread {
    private PricesContainer pricesContainer;
    private Random random = new Random();
    public PricesUpdater(PricesContainer pricesContainer) {
        this.pricesContainer = pricesContainer;
    }

    @Override
    public void run() {
        while(true) {
            pricesContainer.getLock().lock();

            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                pricesContainer.setBitcoinPrice(random.nextInt(20000));
                pricesContainer.setBitcoinCashPrice(random.nextInt(5000));
                pricesContainer.setEtherPrice(random.nextInt(2000));
                pricesContainer.setLitecoinPrice(random.nextInt(5000));
                pricesContainer.setRipplePrice(random.nextDouble());
            } finally {
                pricesContainer.getLock().unlock();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
