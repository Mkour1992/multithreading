package org.java.multithreading.synchronizedCollection;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements  Runnable
{
    private int id;
    CountDownLatch countDownLatch;
public Worker(int id , CountDownLatch countDownLatch)
{
    this.id = id;
    this.countDownLatch = countDownLatch;
}

    /**
     *
     */
    @Override
    public void run() {
doWork();
countDownLatch.countDown();

    }

    private void doWork() {

        try {
            System.out.println("Thread with id "+ this.id + " is working");
            Thread.sleep(200);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Latch {


    public static void main(String[] args) {
CountDownLatch latch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i =0;i<10;i++)
        {
            executorService.execute(new Worker(i,latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks have been finished");
        executorService.shutdown();
    }
}
