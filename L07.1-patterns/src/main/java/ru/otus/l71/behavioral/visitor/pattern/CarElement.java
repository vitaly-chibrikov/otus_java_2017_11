package ru.otus.l71.behavioral.visitor.pattern;

/**
 * Created by tully.
 * <p>
 * Element in the Visitor patter.
 */
public interface CarElement {
    String getName();

    /**
     * Method accept in the Visitor pattern
     *
     * @param visitor to visit the element
     */
    void accept(Service visitor);
}
