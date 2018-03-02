package ru.otus.l142;

/**
 * Example of unsafe code.
 * <p>
 * 1. static
 * 2. volatile
 * 3. synchronized
 * 4. synchronized(object)
 * 5. synchronized(class)
 */

public final class CountedThread extends BaseThread {
    private int i;

    protected synchronized void doSomething() {
        super.doSomething();
        i++;
    }

    int getI() {
        return i;
    }
}
