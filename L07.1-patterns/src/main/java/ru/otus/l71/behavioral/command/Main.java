package ru.otus.l71.behavioral.command;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tully.
 */
public class Main {
    private Queue<Command> commandQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addCommand(new Command2Receiver("Out 1", new Receiver()));
        main.addCommand(new Command2Receiver("Out 2", new Receiver()));

        main.processCommands();
    }


    // add in thread 1
    private void addCommand(Command command) {
        commandQueue.add(command);
    }

    // process in thread 2
    // Invoker of the Command pattern.
    private void processCommands() {
        for (Command command : commandQueue) {
            command.execute();
        }
    }
}
