package by.minsler.hibernate.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: minsler
 * Date: 12/6/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product implements Serializable {

    private Integer id;

    private String name;

    private Integer width;
    private Integer length;
    private Integer height;
    private Integer volume;
    private Integer internalId;

    public Product() {
    }


    public Product(Integer id, String name, Integer width, Integer length, Integer height, Integer volume) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = volume;
    }

    public Product(String name, Integer width, Integer length, Integer height) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (height != null ? !height.equals(product.height) : product.height != null) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (internalId != null ? !internalId.equals(product.internalId) : product.internalId != null) return false;
        if (length != null ? !length.equals(product.length) : product.length != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (volume != null ? !volume.equals(product.volume) : product.volume != null) return false;
        if (width != null ? !width.equals(product.width) : product.width != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (internalId != null ? internalId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", volume=" + volume +
                ", internalId=" + internalId +
                '}';
    }
}