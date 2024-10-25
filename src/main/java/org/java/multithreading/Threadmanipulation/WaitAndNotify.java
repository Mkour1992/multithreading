package org.java.multithreading.Threadmanipulation;


class Process
{

    public void produce() throws InterruptedException {
        synchronized (this)
        {
            System.out.println("Inside the producer!!!");
            wait();
            System.out.println("Again Inside the producer!!!");
        }
    }

    public void consume() throws  InterruptedException{
        Thread.sleep(1000);
        synchronized (this)
        {
            System.out.println("Inside consumer!!!!");
            notify();
        }
    }

}
public class WaitAndNotify {
    public static void main(String[] args) {


        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
t1.start();
t2.start();

    }

}
