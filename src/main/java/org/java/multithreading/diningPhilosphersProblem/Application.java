package org.java.multithreading.diningPhilosphersProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosopher = null;
        ExecutorService executorService = null;
        ChopSticks[] chopSticks = null;
        try {
            philosopher = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
            chopSticks = new ChopSticks[Constants.NUMBER_OF_CHOPSTICKS];
            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
                chopSticks[i] = new ChopSticks(i);
            }
            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
                philosopher[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICKS]);
                executorService.execute(philosopher[i]);
            }
            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for (Philosopher philosopher1 : philosopher) {
                philosopher1.setFull(true);
            }
        } finally {
            executorService.shutdown();
            while (!executorService.isTerminated())
                Thread.sleep(1000);
            for (Philosopher philosopher1 : philosopher) {
                System.out.println(philosopher1 + "eats #" + philosopher1.getEatingCounter() + "times");
            }
        }


    }
}
