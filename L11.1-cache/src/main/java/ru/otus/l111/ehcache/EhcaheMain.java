package ru.otus.l111.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.management.ManagementService;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by tully.
 */
public class EhcaheMain {

    private final CacheManager manager;

    private EhcaheMain(CacheManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) throws InterruptedException {
        org.apache.log4j.BasicConfigurator.configure();
        new EhcaheMain(CacheManager.getInstance()).run();
    }

    private void run() throws InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ManagementService.registerMBeans(manager, mBeanServer, false, true, false, true);

        //cacheNamesExample();
        //evictedExample();
        lifeExample();
        //idleExample();
    }

    private void cacheNamesExample() {
        EhcacheHelper.createEternalCache(manager, "firstCache");

        String[] cacheNames = manager.getCacheNames();
        System.out.println("Caches in the manager: " + Arrays.asList(cacheNames));
    }

    private void evictedExample() {
        System.out.println("\nEternal example\n");
        Cache testCache = EhcacheHelper.createEternalCache(manager, "evictedCache");
        for (int i = 0; i < 2 * EhcacheHelper.MAX_ENTRIES; i++) {
            testCache.put(new Element(i, "Value: " + i));
        }
        System.out.println("Evicted count: " + testCache.getStatistics().cacheEvictedCount());
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void lifeExample() throws InterruptedException {
        System.out.println("\nLife example\n");
        Cache testCache = EhcacheHelper.createLifeCache(manager, "lifeCache");

        new Thread(() -> {
            int index = 0;
            while (true) {
                testCache.put(new Element(index, "String: " + index));
                index++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        int index = 0;
        while (true) {
            testCache.get(index);
            System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
            System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
            Thread.sleep(110);
            index++;
        }
    }

    private void idleExample() throws InterruptedException {
        System.out.println("\nIdle example\n");
        Cache testCache = EhcacheHelper.createIdleCache(manager, "idleCache");
        testCache.put(new Element(0, "String: 0"));
        testCache.get(0);
        System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
        System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
        Thread.sleep(TimeUnit.SECONDS.toMillis(EhcacheHelper.IDLE_TIME_SEC) - 1);
        testCache.get(0);
        System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
        System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
        Thread.sleep(TimeUnit.SECONDS.toMillis(EhcacheHelper.IDLE_TIME_SEC) + 1);
        testCache.get(0);
        System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
        System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
    }
}
