package ru.otus.l141;

class RandomRun {

    private static final int MAX_THREADS_COUNT = 20;

    void start() {
        long startTimeNS = System.nanoTime();
        for (int i = 0; i < MAX_THREADS_COUNT; ++i) {
            new Thread(() -> System.out.println(
                    Thread.currentThread().getName() + ": " + (System.nanoTime() - startTimeNS) + "ns")
            ).start();
        }
    }
}
