package ru.otus.l71.structural.adapter;

/**
 * Created by tully.
 * <p>
 * Polar coordinated to Cartesian coordinated adapter.
 */
public class Polar2CartesianAdapter implements Polar {

    private final Cartesian cartesian;

    public Polar2CartesianAdapter(Cartesian cartesian) {
        this.cartesian = cartesian;
    }

    @Override
    public void setPoint(double r, double theta) {
        cartesian.setPoint(r * Math.cos(theta), r * Math.sin(theta));
    }
}
