package nl.openvalue.samples.multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchExample {

    public static void main(String[] args) {
        final Object LOCK = new Object();
        final int wantedCount = 15;
        final CountDownLatch latch = new CountDownLatch(15);
        for (int i = 0; i < wantedCount; i++) {
            int taskNumber = i;
            new Thread(() -> {
                try {
                    System.out.printf("[%d] Before sleep\n", taskNumber);
                    Thread.sleep(new Random().nextInt(2000));
                    System.out.printf("[%d] After sleep, waiting\n", taskNumber);
                    latch.countDown();
                    synchronized(LOCK) {
                        LOCK.wait();
                    }
                    System.out.printf("[%d] Done waiting\n", taskNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            latch.await();
            synchronized(LOCK) {
                LOCK.notifyAll();
            }
            System.out.println("DONE");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
