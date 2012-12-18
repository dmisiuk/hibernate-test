package by.minsler.hibernate.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/6/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Serializable {

    private Long personId;

    private String name;

    private String surname;

    private Integer age;

    private Country country;

    private Address homeAddress;
    private Address workAddress;
    private Passport passport;

    public Person() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
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


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (homeAddress != null ? !homeAddress.equals(person.homeAddress) : person.homeAddress != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (passport != null ? !passport.equals(person.passport) : person.passport != null) return false;
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
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (workAddress != null ? workAddress.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country=" + country +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", passport=" + passport +
                '}';
    }
}

