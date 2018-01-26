package ru.otus.main;

import ru.otus.base.DBService;
import ru.otus.base.UsersDataSet;
import ru.otus.connection.DBServiceConnection;
import ru.otus.connection.DBServiceUpdate;
import ru.otus.logger.DBServiceLog;
import ru.otus.prepared.DBServicePrepared;
import ru.otus.simple.DBServiceSimple;
import ru.otus.transaction.DBServicePreparedTransactional;

import java.util.List;

/**
 * mysql> CREATE USER 'tully'@'localhost' IDENTIFIED BY 'tully';
 * mysql> GRANT ALL PRIVILEGES ON * . * TO 'tully'@'localhost';
 * mysql> select user, host from mysql.user;
 * mysql> create database db_example;
 * mysql> SET GLOBAL time_zone = '+3:00';
 */

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        try(DBService dbService = new DBServiceConnection()) {
        //try (DBService dbService = new DBServiceUpdate()) {
        //try (DBService dbService = new DBServiceLog()) {
        //try (DBService dbService = new DBServiceSimple()) {
        //try (DBService dbService = new DBServicePrepared()) {
        //try (DBService dbService = new DBServicePreparedTransactional()) {
            System.out.println(dbService.getMetaData());
            dbService.prepareTables();
            dbService.addUsers("tully", "sully");
            System.out.println("UserName with id = 1: " + dbService.getUserName(1));
            List<String> names = dbService.getAllNames();
            System.out.println("All names: " + names.toString());
            List<UsersDataSet> users = dbService.getAllUsers();
            System.out.println("All users: " + users.toString());
            dbService.deleteTables();
        }
    }
}
