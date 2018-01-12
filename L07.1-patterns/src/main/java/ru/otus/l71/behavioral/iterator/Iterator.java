package ru.otus.l71.behavioral.iterator;

/**
 * Created by tully.
 *
 * Traversal abstraction in the Iterator pattern.
 *
 */
public interface Iterator<T> {
    T next();
    boolean hasNext();
}
