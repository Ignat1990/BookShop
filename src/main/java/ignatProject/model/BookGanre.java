package ignatProject.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_ganre")
public class BookGanre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    public BookGanre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        BookGanre bookGanre = (BookGanre) o;
        return id == bookGanre.id && Objects.equals(name, bookGanre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "BookGanre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setTitleName(String name) {
    }
}