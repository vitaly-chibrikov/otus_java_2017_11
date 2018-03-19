package ru.otus.l151.messageSystem;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tully
 */
public final class Address {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final String id;

    public Address(){
        id = String.valueOf(ID_GENERATOR.getAndIncrement());
    }

    public Address(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return id != null ? id.equals(address.id) : address.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String getId() {
        return id;
    }
}
