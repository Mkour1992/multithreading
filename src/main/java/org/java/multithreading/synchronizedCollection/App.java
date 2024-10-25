package org.java.multithreading.synchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {
        //intrinsic lock--not efficient,threads to wait for each other
        //CONCURRENT COLLECTION IS efficient
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    //System.out.println("In Thread1");
//                    synchronized (integers) {
                    integers.add(i);
                    //}
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    //System.out.println("In Thread2");
                    // synchronized (integers) {
                    integers.add(i);
                    //}
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Size of list is" + integers.size());
    }


}
