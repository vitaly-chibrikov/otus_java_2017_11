package ru.otus.l151;


import ru.otus.l151.app.DBService;
import ru.otus.l151.app.FrontendService;
import ru.otus.l151.app.MessageSystemContext;
import ru.otus.l151.db.DBServiceImpl;
import ru.otus.l151.front.FrontendServiceImpl;
import ru.otus.l151.messageSystem.Address;
import ru.otus.l151.messageSystem.MessageSystem;

public class MSMain {
    public static void main(String[] args) throws InterruptedException {
        MessageSystem messageSystem = new MessageSystem();

        MessageSystemContext context = new MessageSystemContext(messageSystem);
        Address frontAddress = new Address("Frontend");
        context.setFrontAddress(frontAddress);
        Address dbAddress = new Address("DB");
        context.setDbAddress(dbAddress);

        FrontendService frontendService = new FrontendServiceImpl(context, frontAddress);
        frontendService.init();

        DBService dbService = new DBServiceImpl(context, dbAddress);
        dbService.init();

        messageSystem.start();

        //for test
        frontendService.handleRequest("tully");
        frontendService.handleRequest("sully");

        frontendService.handleRequest("tully");
        frontendService.handleRequest("sully");

        Thread.sleep(1000);
        messageSystem.dispose();
    }
}
