package org.java.multithreading;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstMapWorker implements  Runnable
{
    private ConcurrentMap<String,Integer> concurrentMap ;

    public FirstMapWorker(ConcurrentMap<String,Integer> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    /**
     *
     */
    @Override
    public void run() {
        doWork();

    }

    private void doWork() {

        try {
            concurrentMap.put("B",12);
            Thread.sleep(1000);
            concurrentMap.put("Z",5);
            concurrentMap.put("A",25);
            Thread.sleep(2000);
            concurrentMap.put("D",19);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}

class SecondMapWorker implements  Runnable
{
    private ConcurrentMap concurrentMap ;

    public SecondMapWorker(ConcurrentMap concurrentMap) {
        this.concurrentMap = concurrentMap;
    }

    /**
     *
     */
    @Override
    public void run() {
        doWork();

    }

    private void doWork() {
        try {
            Thread.sleep(5000);
            System.out.println( concurrentMap.remove("A"));
            Thread.sleep(2000);
            System.out.println(concurrentMap.remove("Z"));
            System.out.println(concurrentMap.remove("B"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

public class ConcurrentMapProcessor  {

    public static void main(String[] args) {
       // Collections.synchronizedMap() not an efficient solution as it uses intrinsic lock,
        ConcurrentMap<String,Integer> concurrentMap = new ConcurrentHashMap<String ,Integer>();

        new Thread(new FirstMapWorker(concurrentMap)).start();
        new Thread(new SecondMapWorker(concurrentMap)).start();



    }


}
