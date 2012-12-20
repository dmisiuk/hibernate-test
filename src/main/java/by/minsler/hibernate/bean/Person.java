package by.minsler.hibernate.bean;

import javax.persistence.*;
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

//<hibernate-mapping
//default-lazy="false"
//default-cascade="all"
//        >
//<class name="by.minsler.hibernate.bean.Person" table="T_PERSON" lazy="false">
//<id name="personId">
//<generator class="sequence">
//<param name="sequense">T_PERSON_SEQ</param>
//</generator>
//</id>
//<property name="name" column="F_NAME" type="string" access="property"/>
//<property name="surname" column="F_SURNAME" type="string" access="property"/>
//<property name="age" column="F_AGE" type="int" access="property"/>

//
//<set name="passportSet"
//        inverse="true" lazy="false" fetch="select">
//<key column="F_PERSON" not-null="true"/>
//<one-to-many class="by.minsler.hibernate.bean.Passport"/>
//</set>
//
//<set name="countrySet" table="COUNTRY_PERSON" inverse="true" lazy="false" fetch="select">
//<key>
//<column name="PERSON_ID" not-null="true" />
//</key>
//<many-to-many entity-name="by.minsler.hibernate.bean.Country">
//<column name="COUNTRY_ID" not-null="true" />
//</many-to-many>
//</set>
//
//
//</class>
//
//</hibernate-mapping>


@Entity
public class Person implements Serializable {

    @Id
    @SequenceGenerator(
            name = "PK",
            sequenceName = "T_PERSON_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer personId;

    private String name;

    private String surname;

    private Integer age;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "PERSON_COUNTRY",
            joinColumns = {@JoinColumn(name = "F_PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "F_COUNTRY_ID")}
    )
    private Set<Country> countrySet;

    @OneToMany(mappedBy = "person")
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

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (passportSet != null ? !passportSet.equals(person.passportSet) : person.passportSet != null) return false;
        if (personId != null ? !personId.equals(person.personId) : person.personId != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (countrySet != null ? countrySet.hashCode() : 0);
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
                ", passportSet=" + passportSet +
                '}';
    }
}

