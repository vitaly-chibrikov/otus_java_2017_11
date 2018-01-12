package ru.otus.l71.structural.proxy;

/**
 * Created by tully.
 * <p>
 * Real subject in the Proxy pattern.
 */
public class SubjectImpl implements Subject {
    @Override
    public void doIt() {
        System.out.println("Done");
    }
}
