package ru.otus.l141;

/**
 * Example of threads' organization.
 * All threads try to print self id. But we need them to print it in serial order.
 */
class SeriesRun {
    private static final int MAX_THREADS_COUNT = 100;

    private int currentMax = 1;

    void start() {
        for (int i = currentMax; i <= MAX_THREADS_COUNT; ++i) {
            int threadId = i; //effectively final
            new Thread(
                    () -> {
                        try {
                            synchronized (SeriesRun.this) {
                                while (threadId > currentMax) {
                                    //System.out.println("Waiting id: " + threadId);
                                    SeriesRun.this.wait();
                                }

                                System.out.println("Thread id: " + threadId);
                                currentMax++;

                                SeriesRun.this.notifyAll();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }

}
