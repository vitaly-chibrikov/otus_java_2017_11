package ru.otus.l71.structural.facade;

import java.util.Collection;
import java.util.List;

/**
 * Created by tully.
 * <p>
 * Facade for java.util.Collections and com.google.common.collect.Collections2
 */
public interface CollectionsFacade {

    <T extends Comparable<? super T>> void sort(List<T> list);

    <T> Collection<List<T>> getPermutations(List<T> list);
}
