package ru.otus.l71.creational.abstract_factory;

/**
 * Created by tully.
 */
public class WinGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }
}
