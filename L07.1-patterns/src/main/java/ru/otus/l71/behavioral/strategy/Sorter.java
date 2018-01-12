package ru.otus.l71.behavioral.strategy;

import java.util.List;

/**
 * Created by tully.
 *
 * Client in the Strategy pattern.
 */
public class Sorter<T> implements Algorithm<T> {
    private Algorithm<T> algorithm;

    public Sorter(Algorithm<T> algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(Algorithm<T> algorithm) {
        this.algorithm = algorithm;
    }

    public void sort(List<T> list) {
        if (algorithm == null) {
            throw new IllegalStateException();
        }
        algorithm.sort(list);
    }
}
