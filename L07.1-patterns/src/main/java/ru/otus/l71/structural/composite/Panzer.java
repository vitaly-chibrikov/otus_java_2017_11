package ru.otus.l71.structural.composite;

/**
 * Created by tully.
 * <p>
 * Leaf in the Composite pattern.
 */
public class Panzer implements Unit {
    @Override
    public void move() {
        System.out.println("Starting engine!");
    }

    @Override
    public void attack() {
        System.out.println("Aiming");
    }

    @Override
    public void hold() {
        System.out.println("Stop machine!");
    }
}
