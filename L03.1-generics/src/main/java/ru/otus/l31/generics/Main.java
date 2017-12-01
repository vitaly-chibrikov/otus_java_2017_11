package ru.otus.l31.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by tully.
 */
@SuppressWarnings({"UnusedReturnValue", "unused", "Convert2Diamond"})
public class Main {
    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
        new Main().start();
    }

    private void start() throws NoSuchFieldException, IllegalAccessException {
        printGenericType();

        //printGenericIfNull();

        //System.out.println("Type name:" + getTypeAfterCompilation().getTypeName());
    }

    private void printGenericIfNull() throws IllegalAccessException, NoSuchFieldException {
        GenericClass stringClassExample = new GenericClass<String>();
        System.out.println(getTypeFromClass(stringClassExample.getClass()));
        System.out.println(getTypeFromObject(stringClassExample));
        System.out.println();
    }

    private void printGenericType() throws IllegalAccessException, NoSuchFieldException {
        GenericClass<Integer> integerClassExample = new GenericClass<Integer>(1);
        System.out.println(getTypeFromClass(integerClassExample.getClass()));
        System.out.println(getTypeFromObject(integerClassExample));
        System.out.println();

        GenericClass<Double> doubleClassExample = new GenericClass<Double>(1.);
        System.out.println(getTypeFromClass(doubleClassExample.getClass()));
        System.out.println(getTypeFromObject(doubleClassExample));
        System.out.println();
    }

    private Type getTypeAfterCompilation() {
        ParameterizedType t = (ParameterizedType) NumberClass.class.getGenericSuperclass();
        return t.getActualTypeArguments()[0];
    }

    private Class<?> getTypeFromClass(Class<? extends GenericClass> clazz) throws IllegalAccessException, NoSuchFieldException {
        return clazz.getDeclaredField("value").getType();
    }

    private Class<?> getTypeFromObject(GenericClass genericClass) throws IllegalAccessException, NoSuchFieldException {
        return genericClass.getClass()
                .getDeclaredField("value")
                .get(genericClass)
                .getClass();
    }

}
