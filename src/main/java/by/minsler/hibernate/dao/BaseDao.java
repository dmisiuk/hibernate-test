package by.minsler.hibernate.dao;

import by.minsler.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: minsler
 * Date: 12/8/12
 * Time: 8:13 PM
 */
public class BaseDao<T> implements Dao<T> {

    private Class cl;

    private HibernateUtil util = HibernateUtil.getInst();

    public BaseDao(Class<T> cl) {
        this.cl = cl;
    }

    @Override
    public T create(T transientObject) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(transientObject);
            tr.commit();
        } catch (HibernateException he) {
            tr.rollback();
            throw new DaoException(he);
        }
        return transientObject;
    }

    @Override
    public T read(Integer id) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        T t;
        try {
            t = (T) session.get(cl, id);
            tr.commit();
        } catch (HibernateException he) {
            tr.rollback();
            throw new DaoException(he);
        }
        return t;
    }

    @Override
    public T update(T transientObject) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        try {
            session.saveOrUpdate(transientObject);
            tr.commit();
        } catch (HibernateException he) {
            tr.rollback();
            throw new DaoException(he);
        }
        return transientObject;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(session.get(cl, id));
            tr.commit();
        } catch (HibernateException he) {
            tr.rollback();
            throw new DaoException(he);
        }
    }

    @Override
    public List<T> readAll() throws DaoException {
        Session session = util.getSession();
        Transaction tr = session.beginTransaction();
        List<T> list = new ArrayList<T>();
        try {
            list = session.createCriteria(cl).list();
            tr.commit();
        } catch (HibernateException he) {
            tr.rollback();
            throw new DaoException(he);
        }
        return list;
    }
}
