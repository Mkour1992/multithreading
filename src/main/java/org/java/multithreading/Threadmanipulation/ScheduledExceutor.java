package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Schedule implements Runnable {

    private final int id;

    public Schedule(int id) {
        this.id = id;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Thread with id " + id + "is in work - thread id " + Thread.currentThread().getId());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

}

public class ScheduledExceutor {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Schedule(i + 1));

        }
//we prevent executor to execute further tasks!!
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
