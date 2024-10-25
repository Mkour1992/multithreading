package org.java.multithreading.Threadmanipulation;

public class ThreadProcess {
    public static int counter1 =0;
    public static int counter2 =0;
    private static final Object lock1 =new Object();
    private static  final Object lock2 = new Object();

    //Class level lock//intrinsic lock//independent methods are locked//object level lock
    public static  void increment1()
    //intrincis/class level lock
    { synchronized (lock1) {
        counter1++;
    }
    }
    public static  void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<100;i++)
                    increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<100;i++)
                    increment2();
            }
        });
        t1.start();
        t2.start();
        t1.join();
t2.join();
        System.out.println("Value of counter "+counter1);
    }


    public static void main(String[] args) throws InterruptedException {

        ThreadProcess.process();


    }
}
