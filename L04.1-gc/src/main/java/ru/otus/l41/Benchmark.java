package ru.otus.l41;

/**
 * Created by tully.
 */
class Benchmark implements BenchmarkMBean {
    private volatile int size = 0;

    @SuppressWarnings("InfiniteLoopStatement")
    void run() {

        System.out.println("Starting the loop");
        while (true) {
            int local = size;
            Object[] array = new Object[local];
            System.out.println("Array of size: " + array.length + " created");

            for (int i = 0; i < local; i++) {
                array[i] = new String(new char[0]);
            }
            System.out.println("Created " + local + " objects.");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

}
