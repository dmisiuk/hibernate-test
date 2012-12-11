package by.minsler.hibernate;

import by.minsler.hibernate.bean.Person;
import by.minsler.hibernate.bean.Product;
import by.minsler.hibernate.dao.BaseDao;
import by.minsler.hibernate.dao.Dao;
import by.minsler.hibernate.dao.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/6/12
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private Dao dao;
    private Dao productDao;

    public Main() {
        dao = new BaseDao(Person.class);
        productDao = new BaseDao(Product.class);
    }

    public static void main(String[] args) throws IOException, DaoException {

        Main m = new Main();

        System.out.println("Maven + Hibernate + Mysql");

        System.out.println("CRUD by Hibernate ORM");

        String menu = "Select operation\n" +
                "c - for create person\n" +
                "r - for read person by id\n" +
                "u - for update person\n" +
                "d - for delete person by id\n" +
                "a - for read all persons\n" +
                "l - for load person by id\n" +
                "cp - for crate product\n" +
                "ap - for read all product\n" +
                "e - for exit";

        String operation = null;

        System.out.println(menu);

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        while (!("e").equals(operation)) {
            System.out.println(menu);
            operation = bufferRead.readLine();
            if ("c".equals(operation)) {
                m.createPerson(bufferRead);
                continue;
            }
            if ("a".equals(operation)) {
                m.readAllPersons();
                continue;
            }

            if ("d".equals(operation)) {
                m.deletePerson(bufferRead);
                continue;
            }

            if ("r".equals(operation)) {
                m.readPerson(bufferRead);
                continue;
            }

            if ("l".equals(operation)) {
                m.loadPerson(bufferRead);
                continue;
            }

            if ("u".equals(operation)) {
                m.updatePerson(bufferRead);
                continue;
            }
            if ("cp".equals(operation)) {
                m.createProduct(bufferRead);
                continue;
            }
            if ("ap".equals(operation)) {
                m.readAllProducts();
                continue;
            }


        }
    }

    private void loadPerson(BufferedReader br) throws IOException, DaoException {
        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());
        Person person = (Person) dao.load(id);

        System.out.println(person);

    }

    private void updatePerson(BufferedReader br) throws IOException, DaoException {
        System.out.println("please enter new person attribute(id,name, surname,age) separated by comma \n" +
                "example: 3,dzmitry,misiuk,25");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        for (String s : atr) {
            System.out.println(s);
        }

        Integer id = Integer.parseInt(atr[0]);
        Person person = new Person();

        person.setName(atr[1]);
        person.setSurname(atr[2]);
        person.setAge(Integer.valueOf(atr[3]));
        dao.update(person);
        System.out.println(person);
    }

    private void deletePerson(BufferedReader br) throws IOException, DaoException {

        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());

        dao.delete(id);

    }

    private void readPerson(BufferedReader br) throws IOException, DaoException {

        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());
        Person person = (Person) dao.read(id);

        System.out.println(person);
    }

    private void readAllPersons() throws DaoException {
        List<Person> persons = (List<Person>) dao.readAll();
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    private void readAllProducts() throws DaoException {
        List<Product> products = (List<Product>) productDao.readAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }


    private void createPerson(BufferedReader br) throws IOException, DaoException {
        Person person = new Person();

        System.out.println("please enter person attribute(name, surname,age) separated by comma \n" +
                "example: dzmitry,misiuk,25");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        person.setName(atr[0]);
        person.setSurname(atr[1]);
        person.setAge(Integer.parseInt(atr[2]));
        dao.create(person);
    }

    private void createProduct(BufferedReader br) throws IOException, DaoException {
        Product person = new Product();

        System.out.println("please enter product attribute(id,name) separated by comma \n" +
                "example: 25,bag");

        String productString = br.readLine();
        String atr[] = productString.split("\\s*,\\s*");

        person.setId(Integer.parseInt(atr[0]));
        person.setName(atr[1]);
        productDao.create(person);
    }
}
