package nl.openvalue.samples.multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LockingWaitingExample {

    public static void main(String[] args) throws InterruptedException {
        final Object LOCK = new Object();

        new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println("Thread: Acquired lock");
                    Thread.sleep(3000);
                    LOCK.wait();
                    System.out.println("Thread: Releasing lock");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Thread.sleep(1000);
        synchronized(LOCK) {
            System.out.println("Acquired lock");
            LOCK.notifyAll();
        }
    }
}
