package ru.otus.l71.creational.abstract_factory;

/**
 * Created by tully.
 * <p>
 * Application in the Abstract Factory pattern.
 */
public class Service {
    private final Button button;
    //private final Window window;
    //private final Menu menu;

    public Service(GUIFactory factory) {
        this.button = factory.createButton();
    }

    public void pressButton() {
        button.printName();
    }
}
