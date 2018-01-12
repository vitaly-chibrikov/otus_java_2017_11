package ru.otus.l71.behavioral.chain;

/**
 * Created by tully.
 */
public class FileLogger extends Logger {
    public FileLogger() {
        super(20);
    }

    @Override
    protected void writeMsg(String msg) {
        //write to the file
        System.err.println(this.getClass().getSimpleName() + ": " + msg);
    }
}
