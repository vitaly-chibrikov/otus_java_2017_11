package ru.otus.l71.behavioral.strategy;

import java.util.ArrayList;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<>(new HeapSort<>());
        sorter.sort(new ArrayList<>());
        sorter.setAlgorithm(new MergeSort<>());
        sorter.sort(new ArrayList<>());
    }
}
