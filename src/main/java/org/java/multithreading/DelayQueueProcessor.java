package org.java.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed
{

private  long duration;
private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DelayedWorker(long duration, String message)
{
    this.duration = System.currentTimeMillis()+duration;
    this.message = message;
}

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * @param unit the time unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "DelayedWorker{" +
                "duration=" + duration +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Delayed other) {
//this is method to compare
        return Long.compare(duration, ((DelayedWorker) other).getDuration());

    }
}
public class DelayQueueProcessor {
//unbounded blocking queue
    public static void main(String[] args) {

        BlockingQueue<DelayedWorker> blockingQueue = new DelayQueue<DelayedWorker>();
        try {
            blockingQueue.put(new DelayedWorker(1000,"This is message-1"));
            blockingQueue.put(new DelayedWorker(10000,"This is message-2"));
            blockingQueue.put(new DelayedWorker(3000,"This is message-3"));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
while(!blockingQueue.isEmpty())
{
    try {
        System.out.println(blockingQueue.take());
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    }
}
