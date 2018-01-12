package ru.otus.l71.behavioral.chain;

/**
 * Created by tully.
 *
 * Handlers in the Chain-of-Responsibility pattern like nodes in LinkedList.
 * Each node tries to process a request. Till the first success.
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = new SystemErrLogger();
        Logger logger20 = new FileLogger();
        Logger logger30 = new DBLogger();

        logger.setNext(logger20);
        logger20.setNext(logger30);

        logger.handle("Msg 5", 5);
        logger.handle("Msg 15", 15);
        logger.handle("Msg 25", 25);
        logger.handle("Msg 35", 35);
    }
}
