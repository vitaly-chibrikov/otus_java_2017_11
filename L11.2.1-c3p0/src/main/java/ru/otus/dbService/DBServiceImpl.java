package ru.otus.dbService;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ru.otus.base.DBService;
import ru.otus.base.dataSets.PhoneDataSet;
import ru.otus.base.dataSets.UserDataSet;
import ru.otus.dbService.dao.UserDataSetDAO;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author v.chibrikov
 */
public class DBServiceImpl implements DBService {
    private final SessionFactory sessionFactory;

    public DBServiceImpl() {

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, Object> settings = new HashMap<>();
        configureHibernate(settings);
        configurePool(settings);
        configureCache(settings);

        //statistics of L2 cache
        //settings.put(Environment.GENERATE_STATISTICS, "true");

        registryBuilder.applySettings(settings);

        ServiceRegistry registry = registryBuilder.build();
        MetadataSources sources = new MetadataSources(registry)
                .addAnnotatedClass(PhoneDataSet.class)
                .addAnnotatedClass(UserDataSet.class);

        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

        registerCacheMBean();

    }

    private void configureCache(Map<String, Object> settings) {
        settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
        settings.put(Environment.USE_QUERY_CACHE, true);
        settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        settings.put("net.sf.ehcache.configurationResourceName", "ehcache.xml");
    }

    private void configurePool(Map<String, Object> settings) {
        settings.put(Environment.C3P0_MIN_SIZE, 5);         //Minimum size of pool
        settings.put(Environment.C3P0_MAX_SIZE, 20);        //Maximum size of pool
        settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);//Number of connections acquired at a time when pool is exhausted
        settings.put(Environment.C3P0_TIMEOUT, 1800);       //Connection idle time
    }

    private void configureHibernate(Map<String, Object> settings) {
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/db_example?useSSL=false");
        settings.put(Environment.USER, "tully");
        settings.put(Environment.PASS, "tully");
        settings.put(Environment.HBM2DDL_AUTO, "create");
        settings.put(Environment.SHOW_SQL, true);
        settings.put(Environment.FORMAT_SQL, true);
        settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
    }

    private void registerCacheMBean() {
        CacheManager manager = CacheManager.getCacheManager(CacheManager.DEFAULT_NAME);
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ManagementService.registerMBeans(manager, mBeanServer, false, false, true, true);
    }

    public String getLocalStatus() {
        return runInSession(session -> session.getTransaction().getStatus().name());
    }

    public void save(UserDataSet dataSet) {
        try (Session session = sessionFactory.openSession()) {
            UserDataSetDAO dao = new UserDataSetDAO(session);
            dao.save(dataSet);
        }
    }

    public UserDataSet read(long id) {
        return runInSession(session -> {
            UserDataSetDAO dao = new UserDataSetDAO(session);
            return dao.read(id);
        });
    }

    public UserDataSet readByName(String name) {
        return runInSession(session -> {
            UserDataSetDAO dao = new UserDataSetDAO(session);
            return dao.readByName(name);
        });
    }

    public List<UserDataSet> readAll() {
        return runInSession(session -> {
            UserDataSetDAO dao = new UserDataSetDAO(session);
            return dao.readAll();
        });
    }

    public void shutdown() {
        sessionFactory.close();
    }

    private <R> R runInSession(Function<Session, R> function) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            R result = function.apply(session);
            transaction.commit();
            return result;
        }
    }
}
