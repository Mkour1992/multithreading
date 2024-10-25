package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 =new ReentrantLock(true);



    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock = new Deadlock();

   new Thread(deadlock::worker1,"worker1").start();
   new Thread(deadlock::worker2,"worker1").start();

    }

    public void worker1()  {
        lock1.lock();
        System.out.println("Worker 1 acquires lock1");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("Worker1 acquires lock2");
        lock1.unlock();
        lock2.unlock();
    }


    public void worker2()
    {  lock2.lock();
        System.out.println("Worker 2 acquires lock2");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock();
        System.out.println("Worker2 acquires lock1");
        lock2.unlock();
        lock1.unlock();

    }
}
