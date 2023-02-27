package ignatProject.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BookGanre")
public class BookGanre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title_name")
    private String titleName;


    @Override
    public String toString() {
        return "BookGanre{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
