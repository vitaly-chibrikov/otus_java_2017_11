package ru.otus.resource;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 * @author v.chibrikov
 */
public class ResourceMain {
    private final static int PORT = 8090;
    private final static String PUBLIC_HTML = "public_html";

    public static void main(String[] args) throws Exception {

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(PUBLIC_HTML);

        Server server = new Server(PORT);
        server.setHandler(resourceHandler);

        server.start();
        server.join();
    }
}