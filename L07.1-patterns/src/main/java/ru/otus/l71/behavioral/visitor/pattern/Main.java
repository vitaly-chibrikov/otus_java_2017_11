package ru.otus.l71.behavioral.visitor.pattern;

import ru.otus.l71.behavioral.visitor.pattern.services.CarRepairService;
import ru.otus.l71.behavioral.visitor.pattern.services.CarWashService;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.doService(new CarRepairService());
        car.doService(new CarWashService());
    }
}
