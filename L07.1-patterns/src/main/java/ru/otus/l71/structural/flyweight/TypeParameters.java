package ru.otus.l71.structural.flyweight;

/**
 * Created by tully.
 * <p>
 * Intrinsic state of shared part of all Letters
 */
public class TypeParameters {
    public static final TypeParameters DEFAULT = new TypeParameters();

    private String name = "Arial";
    private int size = 12;
    private boolean bold = false;
    private boolean italic = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }
}
