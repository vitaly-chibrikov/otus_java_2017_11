package ru.otus.l151.db;

import ru.otus.l151.app.FrontendService;
import ru.otus.l151.app.MsgToFrontend;
import ru.otus.l151.messageSystem.Address;

/**
 * Created by tully.
 */
public class MsgGetUserIdAnswer extends MsgToFrontend {
    private final String name;
    private final int id;

    public MsgGetUserIdAnswer(Address from, Address to, String name, int id) {
        super(from, to);
        this.name = name;
        this.id = id;
    }

    @Override
    public void exec(FrontendService frontendService) {
        frontendService.addUser(id, name);
    }
}
