package ru.otus.l71.creational.bilder;

/**
 * Created by tully.
 * <p>
 * Product in the Builder pattern.
 */
public class BookInfo {
    private final String author;
    private final String name;
    private final int edition;
    private final int index;

    public BookInfo(String author, String name, int edition, int index) {
        this.author = author;
        this.name = name;
        this.edition = edition;
        this.index = index;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getEdition() {
        return edition;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", edition=" + edition +
                ", index=" + index +
                '}';
    }
}
