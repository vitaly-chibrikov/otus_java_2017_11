package ru.otus.jpql;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private LocalDate date;

    protected Book() {
    }

    public Book(String name, Author author, LocalDate date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", date=" + date +
                '}';
    }
}
