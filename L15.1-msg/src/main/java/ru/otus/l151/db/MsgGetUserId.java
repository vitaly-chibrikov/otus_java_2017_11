package ru.otus.l151.db;

import ru.otus.l151.app.DBService;
import ru.otus.l151.app.MsgToDB;
import ru.otus.l151.messageSystem.Address;
import ru.otus.l151.messageSystem.MessageSystem;

/**
 * Created by tully.
 */
public class MsgGetUserId extends MsgToDB {
    private final String login;

    public MsgGetUserId(Address from, Address to, String login) {
        super(from, to);
        this.login = login;
    }

    @Override
    public void exec(DBService dbService) {
        int id = dbService.getUserId(login);
        dbService.getMS().sendMessage(new MsgGetUserIdAnswer(getTo(), getFrom(), login, id));
    }
}
