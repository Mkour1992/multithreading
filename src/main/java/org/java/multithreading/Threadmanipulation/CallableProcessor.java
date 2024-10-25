package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableProcessor implements Callable {

    private int id ;

    public CallableProcessor(int id)
    {
this.id =id;
    }
    /**
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
return id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
    }
}
