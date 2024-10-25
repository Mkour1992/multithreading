package org.java.multithreading;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class  Worker implements  Runnable
{
private int id;
private Random random;

private CyclicBarrier cyclicBarrier;

public Worker(int id, CyclicBarrier cyclicBarrier)
{

    this.id =id;
    this.random =new Random();
this.cyclicBarrier = cyclicBarrier;


}

    /**
     *
     */
    @Override
    public void run() {
doWork();
    }

    private void doWork()  {

        System.out.println("thread with id"+id +"start the work");

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            //when all parties call await() then
            //the barrier is broken
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("aFTER await");
    }
}
public class CyclicBarrierProcessor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //5 number of threads dealing with
CyclicBarrier cyclicBarrier =new CyclicBarrier(5,new Runnable() {
            /**
             *
             */
            @Override
            public void run() {
                System.out.println("All tasks have been finished");
            }
        });

for(int i =0;i<5;i++)
{

    executorService.execute(new Worker(i+1,cyclicBarrier));
}
executorService.shutdown();

    }


}
