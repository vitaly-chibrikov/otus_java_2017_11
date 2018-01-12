package ru.otus.l71.behavioral.mediator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tully.
 */
public class Plane implements Aircraft {
    private final String name;

    private AirportControl control;
    private Set<Integer> dangerous = new HashSet<>();

    private int selfSector;

    public Plane(String name, int selfSector) {
        this.name = name;
        this.selfSector = selfSector;
    }

    @Override
    public void setControl(AirportControl control) {
        this.control = control;
        this.control.addAircraft(this);
    }

    @Override
    public void moveTo(int sector) {
        if (dangerous.contains(sector)) {
            System.out.println("Can't move to: " + sector);
        } else {
            selfSector = sector;
        }
        control.moved(this);
    }

    @Override
    public void addDangerousSector(int sector) {
        dangerous.add(sector);
    }

    @Override
    public void removeDangerousSector(int sector) {
        dangerous.remove(sector);
    }

    @Override
    public int getSector() {
        return selfSector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (selfSector != plane.selfSector) return false;
        if (name != null ? !name.equals(plane.name) : plane.name != null) return false;
        return dangerous != null ? dangerous.equals(plane.dangerous) : plane.dangerous == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", dangerous=" + dangerous +
                ", selfSector=" + selfSector +
                '}';
    }
}
