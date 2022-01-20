package ru.oskin_di.homework_3.task_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private long counter = 0;
    private final Lock lock;

    public Counter() {
        this.lock = new ReentrantLock();
    }

    public void increaseCounter() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}
