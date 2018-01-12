package ru.otus.l71.behavioral.visitor.pattern.elements;

import ru.otus.l71.behavioral.visitor.pattern.CarElement;
import ru.otus.l71.behavioral.visitor.pattern.Service;

/**
 * Created by tully.
 */
public class Body implements CarElement {
    @Override
    public String getName() {
        return "body";
    }

    public void accept(Service visitor) {
        visitor.visit(this);
    }
}
