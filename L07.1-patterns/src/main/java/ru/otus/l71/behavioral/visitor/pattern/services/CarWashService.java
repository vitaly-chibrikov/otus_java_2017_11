package ru.otus.l71.behavioral.visitor.pattern.services;

import ru.otus.l71.behavioral.visitor.pattern.Service;
import ru.otus.l71.behavioral.visitor.pattern.elements.Body;
import ru.otus.l71.behavioral.visitor.pattern.elements.Engine;
import ru.otus.l71.behavioral.visitor.pattern.elements.Wheel;

/**
 * Created by tully.
 */
public class CarWashService implements Service {
    @Override
    public void visit(Wheel element) {
        System.out.println("Washing: " + element.getName());
    }

    @Override
    public void visit(Engine element) {
        System.out.println("Washing: " + element.getName());
    }

    @Override
    public void visit(Body element) {
        System.out.println("Washing: " + element.getName());
    }
}
