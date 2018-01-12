package ru.otus.l71.structural.decorator;

public class UnderscorePrinter extends PrinterDecorator {
    public UnderscorePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String str) {
        StringBuilder builder = new StringBuilder();
        for(char c: str.toCharArray()){
            builder.append(c).append('_');
        }
        super.print(builder.toString());
    }
}
