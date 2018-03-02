package ru.otus.l142;

/**
 * @author v.chibrikov
 */
class InterferenceExample {

    void start() throws InterruptedException {

        CountedThread thread1 = new CountedThread();
        CountedThread thread2 = new CountedThread();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Expected: " + CounterSemaphore.HUNDRED_MILLION);
        System.out.println("Result: " + thread1.getI());
    }
}
