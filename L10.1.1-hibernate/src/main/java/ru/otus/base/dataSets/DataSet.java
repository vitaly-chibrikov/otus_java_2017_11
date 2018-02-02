package ru.otus.base.dataSets;

import javax.persistence.*;

/**
 * Created by tully.
 */
@MappedSuperclass
class DataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }
}
