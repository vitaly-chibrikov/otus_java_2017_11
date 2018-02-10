package ru.otus.l111.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import java.util.function.Consumer;

/**
 * Created by tully.
 */
@SuppressWarnings("SameParameterValue")
class EhcacheHelper {
    static final int MAX_ENTRIES = 50;
    static final int LIFE_TIME_SEC = 1;
    static final int IDLE_TIME_SEC = 1;

    static Cache createLifeCache(CacheManager manager, String name) {
        return createCache(
                manager,
                name,
                configuration -> configuration.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO)
                        .timeToLiveSeconds(LIFE_TIME_SEC));
    }

    static Cache createIdleCache(CacheManager manager, String name) {
        return createCache(
                manager,
                name,
                configuration -> configuration.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO)
                        .timeToIdleSeconds(IDLE_TIME_SEC));
    }

    static Cache createEternalCache(CacheManager manager, String name) {
        return createCache(
                manager,
                name,
                configuration -> configuration.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO)
                        .eternal(true));

    }

    private static Cache createCache(CacheManager manager, String name, Consumer<CacheConfiguration> configurationConsumer) {
        CacheConfiguration configuration = new CacheConfiguration(name, MAX_ENTRIES);
        configurationConsumer.accept(configuration);

        Cache cache = new Cache(configuration);
        manager.addCache(cache);

        return cache;
    }
}
