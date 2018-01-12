package ru.otus.l71.behavioral.visitor.pattern;

import ru.otus.l71.behavioral.visitor.pattern.elements.Body;
import ru.otus.l71.behavioral.visitor.pattern.elements.Engine;
import ru.otus.l71.behavioral.visitor.pattern.elements.Wheel;

/**
 * Created by tully.
 * <p>
 * Visitor in the Visitor pattern.
 * An abstract service for elements of a car.
 */
public interface Service {

    void visit(Wheel element);

    void visit(Engine element);

    void visit(Body element);
}
