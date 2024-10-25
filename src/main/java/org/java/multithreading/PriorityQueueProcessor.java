package org.java.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstPriorityWorker implements Runnable
{
    private BlockingQueue<String> blockingQueue;

    public FirstPriorityWorker(BlockingQueue<String> blockingQueue) {
      this.blockingQueue =blockingQueue;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
        blockingQueue.put("B");
        blockingQueue.put("H");
        blockingQueue.put("F");
        Thread.sleep(2000);
        blockingQueue.put("A");
        Thread.sleep(1000);
        blockingQueue.put("Z");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class SecondPriorityWorker implements Runnable
{
    private BlockingQueue<String> blockingQueue;

    public SecondPriorityWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue =blockingQueue;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
           Thread.sleep(5000);
            System.out.println(blockingQueue.take());
           Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
public class PriorityQueueProcessor {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();
        FirstPriorityWorker firstPriorityWorker =new FirstPriorityWorker(blockingQueue);
        SecondPriorityWorker secondPriorityWorker = new SecondPriorityWorker(blockingQueue);

        new Thread(firstPriorityWorker).start();
        new Thread(secondPriorityWorker).start();
    }


}
