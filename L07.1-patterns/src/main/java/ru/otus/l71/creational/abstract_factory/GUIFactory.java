package ru.otus.l71.creational.abstract_factory;

/**
 * Created by tully.
 * <p>
 * Abstract Factory. Creates abstractions of different elements if UI.
 */
public interface GUIFactory {
    Button createButton();

    //Window createWindow();

    //Menu createMenu();
}
