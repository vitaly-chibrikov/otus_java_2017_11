package ru.otus.l71.creational.factory_method;

/**
 * Created by tully.
 */
public class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
