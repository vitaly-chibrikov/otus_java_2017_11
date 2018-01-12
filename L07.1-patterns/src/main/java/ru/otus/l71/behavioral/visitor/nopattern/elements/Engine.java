package ru.otus.l71.behavioral.visitor.nopattern.elements;

import ru.otus.l71.behavioral.visitor.nopattern.CarElement;

/**
 * Created by tully.
 */
public class Engine implements CarElement {
    @Override
    public String getName() {
        return "engine";
    }

    @Override
    public void doWash() {
        System.out.println("Washing: " + this.getName());
    }

    @Override
    public void doRepair() {
        System.out.println("Repairing: " + this.getName());
    }


}
