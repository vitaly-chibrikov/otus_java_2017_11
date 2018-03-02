package ru.otus.l142;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tully.
 */
class CounterSemaphore {
    static final int HUNDRED_MILLION = 100_000_000;

    private final AtomicInteger count = new AtomicInteger();
    private final static CounterSemaphore instance = new CounterSemaphore();

    private CounterSemaphore() {

    }

    static CounterSemaphore instance() {
        return instance;
    }

    boolean stop() {
        return count.incrementAndGet() > HUNDRED_MILLION;
    }

}
