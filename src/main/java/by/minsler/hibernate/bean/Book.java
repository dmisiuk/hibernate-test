package by.minsler.hibernate.bean;

/**
 * User: minsler
 * Date: 12/15/12
 * Time: 7:54 PM
 */
public class Book extends Product {

    private Integer pages;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
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
                //", internalId=" + super.getInternalId() +
                ",pages= " + this.getPages() +
                '}';
    }
}
