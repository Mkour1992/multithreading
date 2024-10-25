package org.java.multithreading.Threadmanipulation;

import java.util.ArrayList;
import java.util.List;

public class Processor {


    List<Integer> integerList = new ArrayList<>();
    private static int UPPER_LIMIT =5;
    private static int LOWER_LIMIT =0;
    private static int index=0;


    public void producer() throws InterruptedException {
        synchronized (this) {
            while(true)
            {

            if(integerList.isEmpty() ||integerList.size()<UPPER_LIMIT) {
                System.out.println("Inside producer adding"+index);
                integerList.add(index);
                index++;
                notify();

            }
            else {
                System.out.println("Waiting for values to be consumed");
                wait();

            }

            Thread.sleep(500);
            }
        }
    }

    public void consumer() throws  InterruptedException
    {
        synchronized (this) {
            while(true) {
                System.out.println("Inside consumer");
                if(integerList.isEmpty()) {
                    index=0;
                    System.out.println("Waiting for values to be Inserted");
                    wait();
                }



                else {
                    System.out.println("Removing value" +integerList.remove(integerList.size()-1));

                    notify();

            }
                Thread.sleep(500);
            }

        }
    }


    public static void main(String[] args)  throws  InterruptedException{
        Processor processor = new Processor();
        Thread t1 =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }



}
