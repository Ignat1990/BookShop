package bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "data_order")
    private Date dataOrder;
    @Column(name = "comment_order")
    private String commentOrder;
    @Column(name = "total_price")
    private float totalPrice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Users users;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Basket basket;


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dataOrder=" + dataOrder +
                ", commentOrder='" + commentOrder + '\'' +
                ", totalPrice=" + totalPrice +
                ", users=" + users +
                ", statusOrder=" +
                ", basket=" + basket +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
