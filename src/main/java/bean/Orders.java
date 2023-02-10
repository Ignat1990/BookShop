package bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "status_order_id")
    String statusOrderId;
    @Column(name = "data_order")
    Date dataOrder;
    @Column(name = "comment_order")
    String commentOrder;
    @Column(name = "total_price")
    float totalPrice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="status_order")
    private StatusOrder statusOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Basket basket;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(String statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Date getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Date dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(String commentOrder) {
        this.commentOrder = commentOrder;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", statusOrderId='" + statusOrderId + '\'' +
                ", dataOrder=" + dataOrder +
                ", commentOrder='" + commentOrder + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
