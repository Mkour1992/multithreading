package org.java.multithreading.Threadmanipulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
    INSTANCE;
    private final Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {

        try {
            System.out.println("Downloading data from web");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Semaphores {

    public static void main(String[] args) {
//Create multiple threads

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
