package ru.otus.l71.creational.factory_method;

/**
 * Created by tully.
 */
public class CatsHouse extends AnimalHouse {
    @Override
    protected Animal getAnimal() {
        return new Cat();
    }
}
