package org.java.multithreading.Threadmanipulation;


import java.util.stream.IntStream;

class Runner1 implements  Runnable {


    @Override
    public void run() {
        IntStream.rangeClosed(0, 10).forEach(index -> System.out.println("Runner1" + index));
    }
}

    class Runner2 implements  Runnable{

        @Override
        public void run() {
            IntStream.rangeClosed(0, 10).forEach(index -> System.out.println("Runner2" + index));
        }
    }

    public class App {


        public static void main(String[] args) {

            Thread runner1 = new Thread(new Runner1());
            runner1.setPriority(7);
            runner1.start();
           Thread runner2 = new Thread(new Runner2());
           runner2.start();



        }
    }

