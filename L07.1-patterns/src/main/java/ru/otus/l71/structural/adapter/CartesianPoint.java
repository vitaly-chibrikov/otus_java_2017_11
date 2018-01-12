package ru.otus.l71.structural.adapter;

/**
 * Created by tully.
 */
public class CartesianPoint implements Cartesian {
    @Override
    public void setPoint(double x, double y) {
        System.out.println("x: " + x + " y: " + y);
    }
}
