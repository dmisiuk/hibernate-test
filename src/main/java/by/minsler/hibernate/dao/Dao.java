package by.minsler.hibernate.dao;

import java.util.List;

/**
 * User: minsler
 * Date: 12/8/12
 * Time: 8:08 PM
 */
public interface Dao<T> {

    T create(T transientObject) throws DaoException;

    T read(Integer id) throws DaoException;

    T load(Integer id) throws DaoException;

    T update(T transientObject) throws DaoException;

    void delete(Integer id) throws DaoException;

    List<T> readAll() throws DaoException;

    T createDelete(T transientObject) throws DaoException;
}
