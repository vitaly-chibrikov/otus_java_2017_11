package ru.otus.l71.creational.singleton;

/**
 * Created by tully.
 * <p>
 * Singleton pattern
 */
public class Singleton {
    private static Singleton singleton;
    private String message;

    private Singleton() {
    }

    public static Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
