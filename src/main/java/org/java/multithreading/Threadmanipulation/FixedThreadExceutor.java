package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {

    private final int id;

    public Work(int id) {
        this.id = id;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Thread with id " + id + "is in work - thread id " + Thread.currentThread().getId());
        long duration = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupted();
        }
    }

}
public class FixedThreadExceutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i =0;i<100;i++)
        {executorService.execute(new Schedule(i+1));

        }

       executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1000,TimeUnit.MILLISECONDS))
            {
                executorService.shutdownNow();

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
