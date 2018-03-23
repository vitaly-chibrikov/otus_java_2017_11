package ru.otus.l161.server;

import ru.otus.l161.app.Msg;
import ru.otus.l161.app.MsgWorker;
import ru.otus.l161.channel.Blocks;
import ru.otus.l161.channel.SocketMsgWorker;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tully.
 */
public class MirrorSocketMsgServer implements MirrorSocketMsgServerMBean {
    private static final Logger logger = Logger.getLogger(MirrorSocketMsgServer.class.getName());

    private static final int THREADS_NUMBER = 1;
    private static final int PORT = 5050;
    private static final int MIRROR_DELAY_MS = 100;

    private final ExecutorService executor;
    private final List<MsgWorker> clients;

    public MirrorSocketMsgServer() {
        executor = Executors.newFixedThreadPool(THREADS_NUMBER);
        clients = new CopyOnWriteArrayList<>();
    }

    @Blocks
    public void start() throws Exception {
        executor.submit(this::mirror);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            logger.info("Server started on port: " + serverSocket.getLocalPort());
            while (!executor.isShutdown()) {
                Socket socket = serverSocket.accept(); //blocks
                SocketMsgWorker client = new SocketMsgWorker(socket);
                client.init();
                clients.add(client);
            }
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void mirror() {
        while (true) {
            for (MsgWorker client : clients) {
                Msg msg = client.pool();
                while (msg != null) {
                    System.out.println("Mirroring the message: " + msg.toString());
                    client.send(msg);
                    msg = client.pool();
                }
            }
            try {
                Thread.sleep(MIRROR_DELAY_MS);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.toString());
            }
        }
    }

    @Override
    public boolean getRunning() {
        return true;
    }

    @Override
    public void setRunning(boolean running) {
        if (!running) {
            executor.shutdown();
            logger.info("Bye.");
        }
    }
}
