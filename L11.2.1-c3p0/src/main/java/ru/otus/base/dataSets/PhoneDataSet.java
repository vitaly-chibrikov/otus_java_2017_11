package ru.otus.base.dataSets;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by tully.
 */
@Entity
@Table(name = "phone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PhoneDataSet extends DataSet {

    @Column(name = "number")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDataSet user;

    public PhoneDataSet() {
    }

    public PhoneDataSet(String number) {
        this.number = number;
    }

    public void setUser(UserDataSet user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneDataSet{" +
                "number='" + number + '\'' +
                '}';
    }
}
