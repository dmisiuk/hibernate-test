package by.minsler.hibernate.dao;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/8/12
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DaoException extends Exception {

    public DaoException(Exception e) {
        super(e.getMessage());
    }

    public DaoException(String message) {
        super(message);
    }
}