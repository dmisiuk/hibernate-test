package by.minsler.hibernate.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * User: minsler
 * Date: 12/13/12
 * Time: 8:45 PM
 */
public class MyNamingStrategy extends DefaultNamingStrategy {

    @Override
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return "F_" + super.propertyToColumnName(propertyName);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
