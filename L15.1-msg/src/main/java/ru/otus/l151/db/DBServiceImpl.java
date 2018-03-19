package ru.otus.l151.db;

import ru.otus.l151.app.DBService;
import ru.otus.l151.app.MessageSystemContext;
import ru.otus.l151.messageSystem.Address;
import ru.otus.l151.messageSystem.Addressee;
import ru.otus.l151.messageSystem.MessageSystem;

/**
 * Created by tully.
 */
public class DBServiceImpl implements DBService {
    private final Address address;
    private final MessageSystemContext context;

    public DBServiceImpl(MessageSystemContext context, Address address) {
        this.context = context;
        this.address = address;
    }

    public void init() {
        context.getMessageSystem().addAddressee(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }

    public int getUserId(String name) {
        //todo: load id from db
        return name.hashCode();
    }
}
