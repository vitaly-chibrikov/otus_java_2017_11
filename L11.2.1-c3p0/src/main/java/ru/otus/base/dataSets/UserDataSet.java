package ru.otus.base.dataSets;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserDataSet extends DataSet {

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    private List<PhoneDataSet> phones = new ArrayList<>();

    //Important for Hibernate
    public UserDataSet() {
    }

    public UserDataSet(long id, String name, PhoneDataSet... phones) {
        this.setId(id);
        this.setName(name);
        List<PhoneDataSet> userPhones = Arrays.asList(phones);
        this.setPhones(userPhones);
        userPhones.forEach(phone -> phone.setUser(this));
    }

    public UserDataSet(String name, PhoneDataSet... phones) {
        this(-1, name, phones);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneDataSet> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDataSet> phones) {
        this.phones.addAll(phones);
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                ", phones=" + getPhones() +
                '}';
    }
}

