package ru.otus.l71.creational.bilder;

/**
 * Created by tully.
 * <p>
 * Builder in the Builder pattern.
 */
public class BookInfoBuilderImpl implements BookInfoBuilder {
    private final int defaultEdition = 0;
    private final int defaultIndex = 1;

    private String author;
    private String name;
    private int edition = defaultEdition;
    private int index = defaultIndex;

    public BookInfoBuilderImpl setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookInfoBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    public BookInfoBuilderImpl setEdition(int edition) {
        this.edition = edition;
        return this;
    }

    public BookInfoBuilderImpl setIndex(int index) {
        this.index = index;
        return this;
    }

    public BookInfo build() {
        if (author == null) {
            throw new IllegalStateException();
        }
        if (name == null) {
            throw new IllegalStateException();
        }

        return new BookInfo(author, name, edition, index);
    }
}
