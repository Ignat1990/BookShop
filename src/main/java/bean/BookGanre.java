package bean;

import javax.persistence.*;

@Entity
@Table(name = "BookGanre")
public class BookGanre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "title_name")
    String titleName;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="book_ganre_id")
    private Book book;


    @Override
    public String toString() {
        return "BookGanre{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
