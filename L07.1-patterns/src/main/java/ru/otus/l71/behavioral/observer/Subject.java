package ru.otus.l71.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tully.
 * <p>
 * Subject in the Observer pattern.
 */
public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * register new observer.
     *
     * @param observer to register
     */
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * remove observer from the list
     *
     * @param observer to remove
     */
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Send notifications
     *
     * @param event
     */

    public void notify(Event event) {
        observers.forEach(observer -> observer.notify(event));
    }
}
