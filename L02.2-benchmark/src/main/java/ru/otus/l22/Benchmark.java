package ru.otus.l22;

import java.util.function.Supplier;

/**
 * Created by tully.
 */
@SuppressWarnings("MismatchedReadAndWriteOfArray")
class Benchmark {
    private Object[] array;
    private final int size;

    Benchmark() {
        size = 10 * 1000 * 1000;
    }

    Benchmark(int size) {
        this.size = size;
        array = new Object[size];
    }

    void prepare() {
        long memPerArray = getMemChanges(() -> {
            array = new Object[size];
        });

        System.out.println("Reference size: " + memPerArray / size);
    }

    void measure(Supplier<Object> supplier, String name) {
        long memChanges = getMemChanges(() -> {
            int i = 0;
            while (i < size) {
                array[i] = supplier.get();
                i++;
            }
        });
        System.out.println(name + " size: " + Math.round((double) memChanges / size));
    }

    void clean() {
        array = new Object[size];
        BlockingGC.collect();
    }


    private static long getMemChanges(Runnable create) {
        Runtime runtime = Runtime.getRuntime();
        BlockingGC.collect();
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        create.run();
        BlockingGC.collect();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        return memAfter - memBefore;
    }
}
