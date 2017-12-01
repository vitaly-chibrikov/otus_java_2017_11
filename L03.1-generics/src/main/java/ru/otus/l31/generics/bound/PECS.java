package ru.otus.l31.generics.bound;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tully.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class PECS {
    public static void main(String[] args) {
        new PECS().run();
    }

    public void run() {
        List<Number> numbers = new ArrayList<>();
        consume(numbers);
        produce(numbers);
    }

    //list is a producer of elements
    void produce(List<? extends Number> list) {
        System.out.println(list.get(0));
        //list.add(1); // error
    }

    //list is a consumer of elements
    void consume(List<? super Number> list) {
        list.add(1);
        //Number n = list.get(1); // error
    }
}
