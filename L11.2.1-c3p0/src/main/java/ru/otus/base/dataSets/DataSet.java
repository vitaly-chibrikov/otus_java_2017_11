package ru.otus.base.dataSets;

import javax.persistence.*;

/**
 * Created by tully.
 */
@MappedSuperclass
public class DataSet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
