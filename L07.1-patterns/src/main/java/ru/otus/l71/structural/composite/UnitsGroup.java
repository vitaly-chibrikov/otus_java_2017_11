package ru.otus.l71.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tully.
 * <p>
 * Composite.
 */
public class UnitsGroup implements Unit {

    /*
    Units in a group
     */
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void remove(Unit unit) {
        units.remove(unit);
    }

    /*
    Unit's operations
     */
    @Override
    public void move() {
        units.forEach(Unit::move);
    }

    @Override
    public void attack() {
        units.forEach(Unit::attack);
    }

    @Override
    public void hold() {
        units.forEach(Unit::hold);
    }
}
