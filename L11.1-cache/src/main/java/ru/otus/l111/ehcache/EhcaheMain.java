package ru.otus.l111.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

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
        cacheNamesExample();
        //evictedExample();
        //lifeExample();
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

    private void lifeExample() throws InterruptedException {
        System.out.println("\nLife example\n");
        Cache testCache = EhcacheHelper.createLifeCache(manager, "lifeCache");
        testCache.put(new Element(0, "String: 0"));
        testCache.get(0);
        System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
        System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
        Thread.sleep(TimeUnit.SECONDS.toMillis(EhcacheHelper.LIFE_TIME_SEC) + 1);
        testCache.get(0);
        System.out.println("Hit count: " + testCache.getStatistics().cacheHitCount());
        System.out.println("Miss count: " + testCache.getStatistics().cacheMissCount());
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
