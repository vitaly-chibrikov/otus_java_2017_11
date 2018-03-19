package ru.otus.l151.app;

import ru.otus.l151.messageSystem.Addressee;

/**
 * Created by tully.
 */
public interface DBService extends Addressee {
    void init();

    int getUserId(String name);
}
