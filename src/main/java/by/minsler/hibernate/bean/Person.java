package by.minsler.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/6/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Serializable {

    private Integer personId;

    private String name;

    private String surname;

    private Integer age;

    private Set<Country> countrySet;

    private Address homeAddress;
    private Address workAddress;
    private Set<Passport> passportSet;

    public Person() {
        passportSet = new HashSet<Passport>();
        countrySet = new HashSet<Country>();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }


    public Set<Country> getCountrySet() {
        return countrySet;
    }

    public void setCountrySet(Set<Country> countrySet) {
        this.countrySet = countrySet;
    }

    public Set<Passport> getPassportSet() {
        return passportSet;
    }

    public void setPassportSet(Set<Passport> passportSet) {
        this.passportSet = passportSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (countrySet != null ? !countrySet.equals(person.countrySet) : person.countrySet != null) return false;
        if (homeAddress != null ? !homeAddress.equals(person.homeAddress) : person.homeAddress != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (passportSet != null ? !passportSet.equals(person.passportSet) : person.passportSet != null) return false;
        if (personId != null ? !personId.equals(person.personId) : person.personId != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (workAddress != null ? !workAddress.equals(person.workAddress) : person.workAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (countrySet != null ? countrySet.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (workAddress != null ? workAddress.hashCode() : 0);
        result = 31 * result + (passportSet != null ? passportSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", countrySet=" + countrySet +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", passportSet=" + passportSet +
                '}';
    }
}

