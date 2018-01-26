package ru.otus.base;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    String getMetaData();

    void prepareTables() throws SQLException;

    void addUsers(String... names) throws SQLException;

    String getUserName(int id) throws SQLException;

    List<String> getAllNames() throws SQLException;

    List<UsersDataSet> getAllUsers() throws SQLException;

    void deleteTables() throws SQLException;
}
