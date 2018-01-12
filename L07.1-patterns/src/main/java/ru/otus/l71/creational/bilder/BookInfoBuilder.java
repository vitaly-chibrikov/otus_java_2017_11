package ru.otus.l71.creational.bilder;

/**
 * Created by tully.
 */
public interface BookInfoBuilder {
    BookInfoBuilder setAuthor(String author);

    BookInfoBuilder setName(String name);

    BookInfoBuilder setEdition(int edition);

    BookInfoBuilder setIndex(int index);

    BookInfo build();
}
