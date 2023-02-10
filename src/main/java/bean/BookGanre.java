package bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BookGanre")
public class BookGanre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title_name")
    private String titleName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookGanre")
    @JoinColumn(name = "id")
    private List<Book> book;


    @Override
    public String toString() {
        return "BookGanre{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
