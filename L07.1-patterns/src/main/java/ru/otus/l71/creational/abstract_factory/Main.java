package ru.otus.l71.creational.abstract_factory;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String... args) {
        Service serviceWin = new Service(new WinGUIFactory());
        serviceWin.pressButton();

        Service serviceOSX = new Service(new OSXGUIFactory());
        serviceOSX.pressButton();
    }


}
