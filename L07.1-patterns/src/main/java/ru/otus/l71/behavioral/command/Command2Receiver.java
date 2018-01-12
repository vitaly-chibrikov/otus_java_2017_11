package ru.otus.l71.behavioral.command;

/**
 * Created by tully.
 */
public class Command2Receiver implements Command {
    /*
    Variables are "state" of the command
    */
    private final String msg;
    private final Receiver receiver;

    public Command2Receiver(String msg, Receiver receiver) {
        this.msg = msg;
        this.receiver = receiver;
    }

    /**
     * execute() method in Command pattern
     */
    @Override
    public void execute() {
        receiver.action(msg);
    }
}
