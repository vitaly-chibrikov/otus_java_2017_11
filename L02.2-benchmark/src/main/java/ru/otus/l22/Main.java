package ru.otus.l22;

import java.lang.management.ManagementFactory;
import java.util.function.Supplier;

/**
 * Created by tully.
 */
//VM options -Xmx512m -Xms512m
public class Main {

    public static void main(String... args) throws InterruptedException {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        Benchmark benchmark = new Benchmark();
        benchmark.prepare();

        benchmark.measure(Object::new, "Object");
        benchmark.clean();

        benchmark.measure(String::new, "String with pool");
        benchmark.clean();

        benchmark.measure(() -> new String(new char[0]), "String");
        benchmark.clean();

        benchmark.measure(() -> new Benchmark(10), "Benchmark(10)");
        benchmark.clean();
    }
}
