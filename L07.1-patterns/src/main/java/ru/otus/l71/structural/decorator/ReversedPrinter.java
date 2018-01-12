package ru.otus.l71.structural.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tully.
 * <p>
 * This class adds "reversed" functionality to the Printer with help of Decorator.
 */
public class ReversedPrinter extends PrinterDecorator {
    public ReversedPrinter(Printer printer) {
        super(printer);
    }

    private static List<Character> string2CharList(String str) {
        char[] chars = str.toCharArray();
        List<Character> reversed = new ArrayList<>();
        for (char character : chars) {
            reversed.add(character);
        }
        return reversed;
    }

    private static String list2String(List<Character> reversed) {
        StringBuilder builder = new StringBuilder();
        for (char character : reversed) {
            builder.append(character);
        }
        return builder.toString();
    }

    @Override
    public void print(String str) {
        List<Character> list = string2CharList(str);
        Collections.reverse(list);
        String result = list2String(list);

        super.print(result);
    }
}
