package ru.otus.l161.server;

/**
 * Created by tully.
 */
public interface NonBlockingEchoSocketMsgServerMBean {
    boolean getRunning();

    void setRunning(boolean running);
}
