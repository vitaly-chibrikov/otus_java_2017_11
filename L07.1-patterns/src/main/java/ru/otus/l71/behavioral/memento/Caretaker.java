package ru.otus.l71.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tully.
 */
class Caretaker {
    public static void main(String[] args) {
        List<Memento> savedStates = new ArrayList<Memento>();

        Originator originator = new Originator();
        originator.set("A");
        originator.set("B");
        savedStates.add(originator.saveToMemento());
        originator.set("C");
        savedStates.add(originator.saveToMemento());
        originator.set("D");

        originator.restoreFromMemento(savedStates.get(1));
        originator.restoreFromMemento(savedStates.get(0));
    }
}
