package ru.otus.l71.behavioral.template_method;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        BaseClass plus = new Plus(1, 2);
        BaseClass minus = new Minus(1, 2);

        System.out.println(plus.getResult());
        System.out.println(minus.getResult());
    }
}
