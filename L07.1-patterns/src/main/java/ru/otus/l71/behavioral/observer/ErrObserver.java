package ru.otus.l71.behavioral.observer;

/**
 * Created by tully.
 */
public class ErrObserver implements Observer {
    @Override
    public void notify(Event event) {
        System.err.println(event.getClass());
    }
}
