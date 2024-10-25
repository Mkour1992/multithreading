package org.java.multithreading.Threadmanipulation;

class Worker implements Runnable{
    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    private volatile boolean terminated;

    /**
     *
     */
    @Override
    public void run() {

        while(!terminated)
        {
            System.out.println("worker class running");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class VolatileProcessor {
    public static void main(String[] args) throws InterruptedException {
Worker worker =new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        Thread.sleep(3000);
     worker.setTerminated(true);
        System.out.println("Algo is terminated");
    }


}
