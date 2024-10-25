package org.java.multithreading.diningPhilosphersProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopSticks {

private final int id ;
private final Lock lock;

    public ChopSticks(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

public boolean pickUp(Philosopher philosopher, State state)
{
    //This is where we simulate deadlock
    try {
       if( lock.tryLock(10, TimeUnit.MILLISECONDS));
       System.out.println(philosopher+" picked up "+state.toString()+" " +this);
return  true;
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

}
    public void putDown(Philosopher philosopher, State state)
    {
      lock.unlock();
        System.out.println(philosopher+" puts down"+ state.toString()+" " +this);
    }
    /**
     * @return
     */
    @Override
    public String toString() {
        return "Chopstick"+ id;
    }
}
