package org.java.multithreading.diningPhilosphersProblem;

import java.util.Random;

public class Philosopher implements Runnable {

    private final int id;
    private volatile boolean full;
    private final ChopSticks leftChopSticks;
    private final ChopSticks rightChopSticks;
    private final Random random;
    private int eatingCounter;

    public Philosopher(int id, ChopSticks leftChopSticks, ChopSticks rightChopSticks) {
        this.id = id;
        this.leftChopSticks = leftChopSticks;
        this.rightChopSticks = rightChopSticks;
        this.random = new Random();
    }

    /**
     *
     */
    @Override
    public void run() {

        try {
            while (!full) {
                think();
                //philo is able to acquire left chopstick
                if (leftChopSticks.pickUp(this, State.LEFT)) {

                    if (rightChopSticks.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopSticks.putDown(this,State.RIGHT);


                    }
                    leftChopSticks.putDown(this,State.LEFT);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void think() throws InterruptedException {
        System.out.println(this + "= is thinking");
        //philosopher thinks for random time
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + "is eating !!!!!!!!!!");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    private boolean isFull() {
        return this.full;
    }

    public void setFull(boolean full) {
        this.full = full;

    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
