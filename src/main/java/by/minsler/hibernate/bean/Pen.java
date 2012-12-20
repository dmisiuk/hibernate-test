package by.minsler.hibernate.bean;

/**
 * User: minsler
 * Date: 12/15/12
 * Time: 7:51 PM
 */
public class Pen extends Product {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pen pen = (Pen) o;

        if (color != null ? !color.equals(pen.color) : pen.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", width=" + super.getWidth() +
                ", length=" + super.getLength() +
                ", height=" + super.getHeight() +
                ", volume=" + super.getVolume() +
                //   ", internalId=" + super.getInternalId() +
                ",color= " + this.getColor() +
                '}';
    }
}
