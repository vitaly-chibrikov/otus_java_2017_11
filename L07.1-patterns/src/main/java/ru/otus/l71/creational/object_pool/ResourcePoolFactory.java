package ru.otus.l71.creational.object_pool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tully.
 */
public class ResourcePoolFactory implements ResourceFactory {
    private Queue<Resource> pool = new LinkedList<>();

    @Override
    public Resource get() {
        if (pool.isEmpty()) {
            return new PoolResource();
        } else {
            return pool.poll();
        }
    }


    public class PoolResource implements Resource {
        //Real Resource
        private final long creationTime;

        public PoolResource() {
            creationTime = System.nanoTime();
        }

        @Override
        public void print() {
            System.out.println(creationTime);
        }

        @Override
        public void close() {
            pool.add(this);
        }
    }
}
