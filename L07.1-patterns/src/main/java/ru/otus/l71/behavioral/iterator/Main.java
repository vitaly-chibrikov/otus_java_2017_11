package ru.otus.l71.behavioral.iterator;

/**
 * Created by tully.
 *
 * Client in the Iterator pattern.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new List<>("A", "B", "C");
        Iterator<String> iterator = list.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
