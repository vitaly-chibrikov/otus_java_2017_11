package ru.otus.l71.behavioral.state;

/**
 * Created by tully.
 *
 * Context class in the State pattern.
 *
 */
public class StateContext {
   private State state;

    public StateContext(State state) {
        this.state = state;
    }

    public void print(char letter) {
       state.print(this, letter);
    }

    public void setState(State state) {
        this.state = state;
    }
}
