package ru.otus.l71.behavioral.state;

/**
 * Created by tully.
 */
public class LowerCaseState implements State {
    @Override
    public void print(StateContext context, char letter) {
        System.out.print(String.valueOf(letter).toLowerCase());
        if (letter == ' ') {
            context.setState(new UpperCaseState());
        }
    }
}
