package by.minsler.hibernate.bean;

/**
 * User: minsler
 * Date: 12/15/12
 * Time: 9:11 PM
 */
public class Passport {

    private Long personId;

    private String number;

    private Person person;

    public Passport() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
        if (personId != null ? !personId.equals(passport.personId) : passport.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "personId=" + personId +
                ", number='" + number + '\'' +
                '}';
    }
}
