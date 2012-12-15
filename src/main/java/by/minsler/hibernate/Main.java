package by.minsler.hibernate;

import by.minsler.hibernate.bean.*;
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
    private Dao penDao;
    private Dao bookDao;

    public Main() {
        dao = new BaseDao(Person.class);
        productDao = new BaseDao(Product.class);
        penDao = new BaseDao(Pen.class);
        bookDao = new BaseDao(Book.class);
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
                "cd - for create and delete just\n" +
                "cp - for crate product\n" +
                "cpen - for create pen\n" +
                "cbook - for create book\n" +
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
            if ("cpen".equals(operation)) {
                m.createPen(bufferRead);
                continue;
            }

            if ("cbook".equals(operation)) {
                m.createBook(bufferRead);
                continue;
            }

            if ("ap".equals(operation)) {
                m.readAllProducts();
                continue;
            }

            if ("cd".equals(operation)) {
                m.createDeletePerson(bufferRead);
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

        System.out.println("please enter person attribute(name, surname,age,home_sity, home_street, work_sity, work_street) separated by comma \n" +
                "example: dzmitry,misiuk,25,minsk,lesnaia,minsk,skoriny");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        person.setName(atr[0]);
        person.setSurname(atr[1]);
        person.setAge(Integer.parseInt(atr[2]));

        Address homeAddress = new Address();
        homeAddress.setCity(atr[3]);
        homeAddress.setStreet(atr[4]);

        Address workAddress = new Address();
        workAddress.setCity(atr[5]);
        workAddress.setStreet(atr[6]);

        person.setHomeAddress(homeAddress);
        person.setWorkAddress(workAddress);
        dao.create(person);
    }


    private void createDeletePerson(BufferedReader br) throws IOException, DaoException {
        Person person = new Person();

        System.out.println("please enter person attribute(name, surname,age) separated by comma \n" +
                "example: dzmitry,misiuk,25");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        person.setName(atr[0]);
        person.setSurname(atr[1]);
        person.setAge(Integer.parseInt(atr[2]));
        dao.createDelete(person);
    }

    private void createProduct(BufferedReader br) throws IOException, DaoException {


        System.out.println("please enter product attribute(name,length, width, height,internalId) separated by comma \n" +
                "example: bag,2,45,5,27");

        String productString = br.readLine();
        String atr[] = productString.split("\\s*,\\s*");

        String name = atr[0];
        int length = Integer.parseInt(atr[1]);
        int width = Integer.parseInt(atr[2]);
        int heigth = Integer.parseInt(atr[3]);
        int internalId = Integer.parseInt(atr[4]);

        Product product = new Product(name, width, length, heigth);
        product.setInternalId(internalId);

        productDao.create(product);
    }

    private void createPen(BufferedReader bufferRead) throws IOException, DaoException {
        System.out.println("please enter product attribute(name,length, width, height,internalId,color) separated by comma \n" +
                "example: pen,2,45,5,27,grey");

        String productString = bufferRead.readLine();
        String atr[] = productString.split("\\s*,\\s*");

        String name = atr[0];
        int length = Integer.parseInt(atr[1]);
        int width = Integer.parseInt(atr[2]);
        int heigth = Integer.parseInt(atr[3]);
        int internalId = Integer.parseInt(atr[4]);
        String color = atr[5];

        Pen pen = new Pen();
        pen.setName(name);
        pen.setLength(length);
        pen.setWidth(width);
        pen.setHeight(heigth);
        pen.setInternalId(internalId);
        pen.setColor(color);


        penDao.create(pen);
    }

    private void createBook(BufferedReader bufferRead) throws IOException, DaoException {
        System.out.println("please enter product attribute(name,length, width, height,internalId,pages) separated by comma \n" +
                "example: hobbit,2,45,5,27,1022");

        String productString = bufferRead.readLine();
        String atr[] = productString.split("\\s*,\\s*");

        String name = atr[0];
        int length = Integer.parseInt(atr[1]);
        int width = Integer.parseInt(atr[2]);
        int heigth = Integer.parseInt(atr[3]);
        int internalId = Integer.parseInt(atr[4]);
        int pages = Integer.parseInt(atr[5]);

        Book book = new Book();
        book.setName(name);
        book.setLength(length);
        book.setWidth(width);
        book.setHeight(heigth);
        book.setInternalId(internalId);
        book.setPages(pages);

        bookDao.create(book);

    }
}
