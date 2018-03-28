package ru.otus.l161.server;

import ru.otus.l161.channel.Blocks;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tully.
 */
public class NonBlockingLogSocketMsgServer {
    private static final Logger logger = Logger.getLogger(NonBlockingEchoSocketMsgServer.class.getName());

    private static final int PORT = 5050;
    private static final int CAPACITY = 256;

    @SuppressWarnings("InfiniteLoopStatement")
    @Blocks
    public void start() throws Exception {

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress("localhost", PORT));

            serverSocketChannel.configureBlocking(false); //non blocking mode

            Selector selector = Selector.open();
            int ops = SelectionKey.OP_ACCEPT;
            serverSocketChannel.register(selector, ops, null);

            logger.info("Started on port: " + PORT);

            while (true) {
                selector.select();//blocks
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    try {
                        if (key.isAcceptable()) {
                            SocketChannel client = serverSocketChannel.accept(); //non blocking accept
                            System.out.println("Connection Accepted: " + client.getRemoteAddress());

                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                        } else if (key.isReadable()) {
                            SocketChannel channel = (SocketChannel) key.channel();

                            ByteBuffer buffer = ByteBuffer.allocate(CAPACITY);
                            int read = channel.read(buffer);
                            if (read != -1) {
                                String result = new String(buffer.array()).trim();
                                if (!result.isEmpty())
                                    System.out.println("Message received: " + result + " from: " + channel.getRemoteAddress());
                            } else {
                                key.cancel();
                                System.out.println("Connection closed, key canceled");
                            }
                        }
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    } finally {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
