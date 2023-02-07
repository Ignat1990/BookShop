package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookGanre")
public class BookGanre {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "title_name")
    String titleName;


    @Override
    public String toString() {
        return "BookGanre{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
