package org.java.multithreading;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class FirstWorker implements  Runnable
{
private BlockingQueue<Integer> blockingQueue;

public FirstWorker(BlockingQueue<Integer> blockingQueue)
{
this.blockingQueue = blockingQueue;
}
    /**
     *
     */
    @Override
    public void run() {
        int counter =0;
while(true)
{
    try {
        blockingQueue.put(counter);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Putting elements in queue"  +counter);
counter++;
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    }
}
class SecondWorker implements  Runnable
{
    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
    }
    /**
     *
     */
    @Override
    public void run() {

        while(true)
        {
            try {
              int counter =  blockingQueue.take();
                System.out.println("Taking elements from queue  " +counter);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}

public class BlockingQueueProcessor {


    public static void main(String[] args) {
BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
FirstWorker firstWorker = new FirstWorker(blockingQueue);
SecondWorker secondWorker = new SecondWorker(blockingQueue);
       new Thread(firstWorker).start();
       new Thread(secondWorker).start();

    }
}
