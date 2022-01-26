package nl.openvalue.samples.multithreading;

import java.util.concurrent.*;

public class ExecutorCallableExample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> first = es.submit(() -> {
            Thread.sleep(1000);
            return "Hello";
        });
        es.shutdown();

        String msg;
        try {
            msg = first.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Message:" + msg);
    }

}
