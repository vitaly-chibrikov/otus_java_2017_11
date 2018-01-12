package ru.otus.l71.behavioral.template_method;

/**
 * Created by tully.
 * <p>
 * Framework class in the Template method pattern.
 */
public abstract class BaseClass {
    /*
    Common part of the subclasses.
     */
    private final int result;

    public BaseClass(int a, int b) {
        result = apply(a, b);
    }

    public int getResult() {
        return result;
    }


    /**
     * Different algorithms of the subclasses.
     *
     * @param a the first argument
     * @param b the second argument
     * @return result of the algorithm
     */
    protected abstract int apply(int a, int b);
}
