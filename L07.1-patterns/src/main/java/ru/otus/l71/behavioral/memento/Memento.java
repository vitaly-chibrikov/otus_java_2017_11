package ru.otus.l71.behavioral.memento;

/**
 * Created by tully.
 */
public class Memento {
    private final String state;

    public Memento(String stateToSave) {
        state = stateToSave;
    }

    public String getSavedState() {
        return state;
    }
}
