package org.java.multithreading;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class ReadTask implements Runnable
{
    private List<Integer> integerList;

    public ReadTask(List<Integer> integerList) {
        this.integerList = integerList;
    }


    /**
     *
     */
    @Override
    public void run() {

        while(true)
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("List is"+ integerList);

        }


    }
}


class WriteTask implements  Runnable
{
private List<Integer> integerList;
Random random;

    public WriteTask(List<Integer> integerList) {
        this.integerList = integerList;
        this.random = new Random();
    }


    /**
     *
     */
    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(50);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            integerList.set( random.nextInt(integerList.size()),random.nextInt(10) );

        }

    }
}



public class CopyOnWriteArrayProcessor {
    public static void main(String[] args) {
        List<Integer> integerList = new CopyOnWriteArrayList<>();
        integerList.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0));
        Iterator<Integer> integerIterator =integerList.listIterator();
        while(integerIterator.hasNext())
        {
            integerIterator.remove();
        }
        Thread t1 = new Thread(new WriteTask(integerList));
        Thread t2 = new Thread(new WriteTask(integerList));
        Thread t3 = new Thread(new WriteTask(integerList));
        Thread t4 = new Thread(new ReadTask(integerList));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }


}
