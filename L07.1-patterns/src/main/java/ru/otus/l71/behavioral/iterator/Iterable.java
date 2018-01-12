package ru.otus.l71.behavioral.iterator;

/**
 * Created by tully.
 *
 * Abstract Collection in the Iterator pattern.
 */
public interface Iterable<T> {
    Iterator<T> getIterator();
}
