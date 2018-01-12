package ru.otus.l71.behavioral.memento;

/**
 * Created by tully.
 *
 * Originator in the Memento pattern.
 */
class Originator {
    /*
    State of the originator in the Memento pattern.
    */
    private String state;

    public void set(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving " + this.state + " to Memento.");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

}
