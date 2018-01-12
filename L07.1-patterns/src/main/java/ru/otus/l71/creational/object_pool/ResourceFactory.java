package ru.otus.l71.creational.object_pool;

/**
 * Created by tully.
 */
@FunctionalInterface
public interface ResourceFactory {
    Resource get();
}
