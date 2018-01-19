package ru.otus.l081.gson;

/**
 * Created by tully.
 */
@SuppressWarnings("WeakerAccess")
class BagOfPrimitives {
    private final int value1;
    private final String value2;
    private final int value3;

    public BagOfPrimitives(int value1, String value2, int value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    private BagOfPrimitives() {
        value1 = 1;
        value2 = "abc";
        value3 = 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BagOfPrimitives that = (BagOfPrimitives) o;

        if (value1 != that.value1) return false;
        if (value3 != that.value3) return false;
        return value2 != null ? value2.equals(that.value2) : that.value2 == null;
    }

    @Override
    public String toString() {
        return "BagOfPrimitives{" +
                "value1=" + value1 +
                ", value2='" + value2 + '\'' +
                ", value3=" + value3 +
                '}';
    }
}
