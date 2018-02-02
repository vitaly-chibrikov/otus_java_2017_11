package ru.otus.base.dataSets;

import javax.persistence.*;

/**
 * Created by tully.
 */
@Entity
public class EmptyDataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
