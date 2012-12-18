package by.minsler.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private SessionFactory sf;

    private final ThreadLocal sessions = new ThreadLocal();

    private static HibernateUtil inst = new HibernateUtil();

    private HibernateUtil() throws ExceptionInInitializerError {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration config = new Configuration();
            config.setNamingStrategy(new MyNamingStrategy());
            this.sf = config.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static HibernateUtil getInst() {
        return inst;
    }

    public Session getSession() {
        Session session = (Session) sessions.get();
        if (session == null) {
            session = sf.openSession();
            sessions.set(session);
        }
        return session;
    }

}