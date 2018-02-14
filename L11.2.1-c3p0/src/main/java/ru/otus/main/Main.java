package ru.otus.main;

import ru.otus.base.DBService;
import ru.otus.base.dataSets.PhoneDataSet;
import ru.otus.base.dataSets.UserDataSet;
import ru.otus.dbService.DBServiceImpl;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * for mysql:
 * SET GLOBAL time_zone = '+3:00';
 */

public class Main {
    private static final long WORK_TIME_MS = TimeUnit.MINUTES.toMillis(2);
    private static final long STEP_MIME_MS = TimeUnit.SECONDS.toMillis(5);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());

        DBService dbService = new DBServiceImpl();

        String status = dbService.getLocalStatus();
        System.out.println("Status: " + status);

        dbService.save(new UserDataSet("tully", new PhoneDataSet("12345")));
        dbService.save(new UserDataSet("sully", new PhoneDataSet("67890")));

        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < WORK_TIME_MS) {

            System.out.println(dbService.read(1));
            System.out.println(dbService.readByName("sully"));

            List<UserDataSet> dataSets = dbService.readAll();
            for (UserDataSet userDataSet : dataSets) {
                System.out.println(userDataSet);
            }

            Thread.sleep(STEP_MIME_MS);
        }

        dbService.shutdown();
    }
}
