package ru.otus.l31.generics;

/**
 * Created by tully.
 */
@SuppressWarnings("WeakerAccess")
public class GenericClass<T> {
    //public for Reflection
    public T value;

    public GenericClass() {
        this.value = null;
    }

    public GenericClass(T value) {
        this.value = value;
    }

    public T getT() {
        return value;
    }

    public void run() {
        GenericClass<Integer> intObject = new GenericClass<>(1);
        Integer valueInteger = intObject.getT();

        GenericClass<String> stringObject = new GenericClass<>("word");
        String valueString = stringObject.getT();
    }
}
