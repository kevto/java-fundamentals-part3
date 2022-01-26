package nl.openvalue.samples.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExtensionExample {

    public static class ThreadExtension extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                System.out.println("is doing some work");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadExtension t1 = new ThreadExtension();
        t1.start();

        Thread.sleep(5000);
        t1.interrupt();
        System.out.println("Work done");
    }

}
