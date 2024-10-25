package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    private final int id;

    public Task(int id) {
        this.id = id;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Thread with id " + id + "is in work - thread id " + Thread.currentThread().getName());
        long duration = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
public class SingleThreadExceutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i =0;i<5;i++)
        {executorService.execute(new Schedule(i));

        }

        executorService.shutdown();

    }
}
