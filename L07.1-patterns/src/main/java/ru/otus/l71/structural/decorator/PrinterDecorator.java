package ru.otus.l71.structural.decorator;

/**
 * Created by tully.
 * <p>
 * Optional wrapper in the Decorator pattern.
 */
public class PrinterDecorator implements Printer {
    private final Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String str) {
        printer.print(str);
    }
}
