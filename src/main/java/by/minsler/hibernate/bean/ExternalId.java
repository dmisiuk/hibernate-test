package by.minsler.hibernate.bean;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * User: minsler
 * Date: 12/20/12
 * Time: 8:25 PM
 */
@Entity
public class ExternalId {

    @Id
    @GenericGenerator(
            name = "gen",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "product")
    )
    @GeneratedValue(generator = "gen")
    private String id;

    private Integer value;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Product product;

    public ExternalId() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalId that = (ExternalId) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExternalId{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
