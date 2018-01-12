package ru.otus.l71.structural.facade;

import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by tully.
 */
public class CollectionsFacadeImpl implements CollectionsFacade {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        Collections.sort(list);
    }

    @Override
    public <T> Collection<List<T>> getPermutations(List<T> list) {
        return Collections2.permutations(list);
    }
}
