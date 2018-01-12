package ru.otus.l71.creational.bilder;

/**
 * Created by tully.
 * <p>
 * Director in the Builder pattern.
 */
public class Main {
    public static void main(String... args) {
        BookInfoBuilder builder = new BookInfoBuilderImpl();

        BookInfo info = builder
                .setAuthor("Tully")
                .setName("Java before and after")
                .setEdition(1)
                .build();

        System.out.println(info);
    }
}
