package by.minsler.hibernate.bean;

/**
 * User: minsler
 * Date: 12/15/12
 * Time: 9:11 PM
 */
public class Passport {

    private Integer id;

    private String number;

    private Person person;

    public Passport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (number != null ? !number.equals(passport.number) : passport.number != null) return false;
        if (id != null ? !id.equals(passport.id) : passport.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ",person_name=" + person.getName() +
                ",person_surname=" + person.getSurname() +
                '}';
    }
}
