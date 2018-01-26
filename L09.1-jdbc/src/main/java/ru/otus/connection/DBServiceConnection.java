package ru.otus.connection;

import ru.otus.base.DBService;
import ru.otus.base.UsersDataSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBServiceConnection implements DBService {

    private final Connection connection;

    public DBServiceConnection() {
        connection = ConnectionHelper.getConnection();
    }

    @Override
    public String getMetaData() {
        try {
            return "Connected to: " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n" +
                    "DB version: " + getConnection().getMetaData().getDatabaseProductVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName();
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public void prepareTables() throws SQLException {
    }

    @Override
    public void addUsers(String... names) throws SQLException {
    }

    @Override
    public String getUserName(int id) throws SQLException {
        return null;
    }

    @Override
    public List<String> getAllNames() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public List<UsersDataSet> getAllUsers() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public void deleteTables() throws SQLException {
    }

    @Override
    public void close() throws Exception {
        connection.close();
        System.out.println("Connection closed. Bye!");
    }

    protected Connection getConnection() {
        return connection;
    }


}
