package by.minsler.hibernate;

import by.minsler.hibernate.bean.*;
import by.minsler.hibernate.dao.BaseDao;
import by.minsler.hibernate.dao.Dao;
import by.minsler.hibernate.dao.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/6/12
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private Dao personDao;
    private Dao productDao;
    private Dao penDao;
    private Dao bookDao;
    private Dao countryDao;
    private Dao passportDao;

    public Main() {
        personDao = new BaseDao(Person.class);
        productDao = new BaseDao(Product.class);
        penDao = new BaseDao(Pen.class);
        bookDao = new BaseDao(Book.class);
        countryDao = new BaseDao(Country.class);
        passportDao = new BaseDao(Passport.class);
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
                "ccountry - for create country\n" +
                "cpas - for create passport for person\n" +
                "apas - for read all  passports\n" +
                "p_to_c - for add person to country\n" +
                "ac - for read all countries\n" +
                "ap - for read all product\n" +
                "e - for exit";

        String operation = null;

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
            if ("ccountry".equals(operation)) {
                m.creatCountry(bufferRead);
                continue;
            }

            if ("cpas".equals(operation)) {
                m.createPassportForPerson(bufferRead);
                continue;
            }

            if ("apas".equals(operation)) {
                m.readAllPassports();
                continue;
            }

            if ("acountry".equals(operation)) {
                m.readAllCountries();
                continue;
            }

            if ("ac".equals(operation)) {
                m.readAllCountries();
                continue;
            }

            if ("p_to_c".equals(operation)) {
                m.addPersonToCountry(bufferRead);
            }


        }
    }

    private void createPassportForPerson(BufferedReader bufferRead) throws IOException, DaoException {

        System.out.println("please enter passport attribute(person_id, passport_number) separated by comma \n" +
                "example: 1,23423423");

        String personString = bufferRead.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        int personId = Integer.parseInt(atr[0]);
        String passportNumber = atr[1];

        Person person = (Person) personDao.read(personId);

        Passport passport = new Passport();
        passport.setNumber(passportNumber);
        passport.setPerson(person);
        Set<Passport> passports = person.getPassportSet();

        passports.add(passport);

        personDao.update(person);
    }


    private void addPersonToCountry(BufferedReader bufferRead) throws IOException, DaoException {

        System.out.println("please enter person,country attributes(person_id, countryid) separated by comma \n" +
                "example: 1,3");

        String personString = bufferRead.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        int personId = Integer.parseInt(atr[0]);
        int countryId = Integer.parseInt(atr[1]);

        Person person = (Person) personDao.read(personId);
        Country country = (Country) countryDao.read(countryId);

        country.getPersonSet().add(person);
        person.getCountrySet().add(country);

        personDao.update(person);
    }


    private void readAllPassports() throws DaoException {
        List<Passport> passports = (List<Passport>) passportDao.readAll();
        for (Passport p : passports) {
            System.out.println(p);
        }
    }


    private void readAllCountries() throws DaoException {
        List<Country> countries = (List<Country>) countryDao.readAll();
        for (Country c : countries) {
            System.out.println(c);
        }
    }


    private void loadPerson(BufferedReader br) throws IOException, DaoException {
        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());
        Person person = (Person) personDao.load(id);

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
        personDao.update(person);
        System.out.println(person);
    }

    private void deletePerson(BufferedReader br) throws IOException, DaoException {

        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());

        personDao.delete(id);

    }

    private void readPerson(BufferedReader br) throws IOException, DaoException {

        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());
        Person person = (Person) personDao.read(id);

        System.out.println(person);
    }

    private void readAllPersons() throws DaoException {
        List<Person> persons = (List<Person>) personDao.readAll();
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

//        int country_id = Integer.parseInt(atr[8]);
//        Country country = (Country) countryDao.read(country_id);
//        System.out.println("person set: " + country.getPersonSet());
//        Set<Person> personSet = country.getPersonSet();
//        if (personSet == null) {
//            personSet = new HashSet<Person>();
//            country.setPersonSet(personSet);
//        }
//
//        person.setCountry(country);
//        country.getPersonSet().add(person);

        personDao.create(person);
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
        personDao.createDelete(person);
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

    private void creatCountry(BufferedReader bufferRead) throws IOException, DaoException {
        System.out.println("please enter country  attribute(name) separated by comma \n" +
                "example: belarus");

        String productString = bufferRead.readLine();
        String atr[] = productString.split("\\s*,\\s*");

        String name = atr[0];
        Country country = new Country();
        country.setName(name);

        countryDao.create(country);
    }
}
