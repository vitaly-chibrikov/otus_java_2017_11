package ru.otus.base.dataSets;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDataSet extends DataSet {

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private PhoneDataSet phone;

    //Important for Hibernate
    public UserDataSet() {
    }

    public UserDataSet(String name, PhoneDataSet phone) {
        this.setId(-1);
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public PhoneDataSet getPhone() {
        return phone;
    }

    private void setPhone(PhoneDataSet phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id'" + getId() + '\'' +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}

