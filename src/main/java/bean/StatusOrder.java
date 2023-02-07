package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "StatusOrder")
public class StatusOrder {
    @Id
    @Column(name = "id")
    int id;
    @Column(name="status_order")
    String statusOrder;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusOrder that = (StatusOrder) o;
        return id == that.id && Objects.equals(statusOrder, that.statusOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusOrder);
    }

    @Override
    public String toString() {
        return "StatusOrder{" +
                "id=" + id +
                ", statusOrder='" + statusOrder + '\'' +
                '}';
    }

}
