package by.minsler.hibernate;

import by.minsler.hibernate.bean.Person;
import by.minsler.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

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

    public static void main(String[] args) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        System.out.println("Maven + Hibernate + Mysql");

        System.out.println("CRUD by Hibernate ORM");

        String menu = "Select operation\n" +
                "c - for create person\n" +
                "r - for read person by id\n" +
                "u - for update person\n" +
                "d - for delete person by id\n" +
                "a - for read all persons\n" +
                "e - for exit";

        String operation = null;

        System.out.println(menu);

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        while (!("e").equals(operation)) {
            System.out.println(menu);
            operation = bufferRead.readLine();
            if ("c".equals(operation)) {
                createPerson(bufferRead, session);
                continue;
            }
            if ("a".equals(operation)) {
                readAllPersons(session);
                continue;
            }

            if ("d".equals(operation)) {
                deletePerson(bufferRead, session);
                continue;
            }

            if ("r".equals(operation)) {
                readPerson(bufferRead, session);
                continue;
            }

            if ("u".equals(operation)) {
                updatePerson(bufferRead, session);
                continue;
            }

        }
    }

    private static void updatePerson(BufferedReader br, Session session) throws IOException {
        session.beginTransaction();

        System.out.println("please enter new person attribute(id,name, surname,age) separated by comma \n" +
                "example: 3,dzmitry,misiuk,25");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");

        for (String s : atr) {
            System.out.println(s);
        }

        Integer id = Integer.parseInt(atr[0]);

        Person person = (Person) session.get(Person.class, id);
        System.out.println(person);

        person.setName(atr[1]);
        person.setSurname(atr[2]);
        person.setAge(Integer.valueOf(atr[3]));
        System.out.println(person);
        session.update(person);
        session.getTransaction().commit();
    }

    private static void deletePerson(BufferedReader br, Session session) throws IOException {
        session.beginTransaction();
        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());


        Person person = (Person) session.get(Person.class, id);

        System.out.println(person);

        session.delete(person);

        session.getTransaction().commit();
    }

    private static void readPerson(BufferedReader br, Session session) throws IOException {
        session.beginTransaction();

        System.out.println("please enter id of person  \n" +
                "example: 2");

        String idString = br.readLine();
        Integer id = Integer.valueOf(idString.trim());

        Person person = (Person) session.get(Person.class, id);

        System.out.println(person);

        session.getTransaction().commit();
    }

    private static void readAllPersons(Session session) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Person.class);

        List<Person> persons = criteria.list();
        for (Person p : persons) {
            System.out.println(p);
        }

        session.getTransaction().commit();
    }


    private static void createPerson(BufferedReader br, Session session) throws IOException {

        session.beginTransaction();

        Person person = new Person();

        System.out.println("please enter person attribute(name, surname,age) separated by comma \n" +
                "example: dzmitry,misiuk,25");

        String personString = br.readLine();
        String atr[] = personString.split("\\s*,\\s*");


        person.setName(atr[0]);
        person.setSurname(atr[1]);
        person.setAge(Integer.parseInt(atr[2]));
        session.save(person);

        session.getTransaction().commit();
    }
}
