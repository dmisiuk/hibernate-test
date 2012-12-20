package by.minsler.hibernate.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: minsler
 * Date: 12/18/12
 * Time: 7:45 PM
 */

//<class name="by.minsler.hibernate.bean.Country" lazy="false">
//<id name="id">
//<generator class="sequence">
//<param name="sequence">T_COUNTRY_SEQ</param>
//</generator>
//</id>
//<property name="name"/>
//
//
//<set name="personSet" table="COUNTRY_PERSON"
//        inverse="false" lazy="false" fetch="select" cascade="all">
//<key>
//<column name="COUNTRY_ID" not-null="true"/>
//</key>
//<many-to-many entity-name="by.minsler.hibernate.bean.Person">
//<column name="PERSON_ID" not-null="true"/>
//</many-to-many>
//</set>
//
//</class>

@Entity
public class Country implements Serializable {

    @Id
    @SequenceGenerator(
            name = "PK",
            sequenceName = "T_COUNTRY_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private Integer id;

    @ManyToMany(mappedBy = "countrySet")
    private Set<Person> personSet;

    private String name;

    public Country() {
        personSet = new HashSet<Person>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
