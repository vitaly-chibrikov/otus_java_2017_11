package ru.otus.simple;

import ru.otus.executor.TExecutor;
import ru.otus.logger.DBServiceLog;

import java.sql.SQLException;

public class DBServiceSimple extends DBServiceLog {
    private static final String SELECT_USER = "select name from user where id=%s";

    @Override
    public String getUserName(int id) throws SQLException {
        TExecutor execT = new TExecutor(getConnection());

        return execT.execQuery(String.format(SELECT_USER, id), result -> {
            result.next();
            return result.getString("name");
        });
    }
}
