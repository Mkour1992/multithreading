package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {


private static  AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerExample atomicInteger = new AtomicIntegerExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.increment();
            }
        });
        t1.start();
t2.start();
t1.join();
t2.join();
        System.out.println("Counter is"+counter);

    }
public  void  increment()
{for(int i =0;i<1000;i++)
   counter.getAndIncrement();
}
}
