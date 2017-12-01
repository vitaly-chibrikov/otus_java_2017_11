package ru.otus.l31.generics.bound;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "unused"})
public class Wildcard {
    public static void main(String[] args) {
        new Wildcard().run();
    }

    private void run() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        //printListOld(list);

        printList(list);
    }

    private void printList(List<?> list) {
        list.forEach(System.out::println);
        //list.add(new Object()); // error
    }

    private void printListOld(List list) {
        list.forEach(System.out::println);
        list.add(new Object());
        list.add(2);
    }
}
