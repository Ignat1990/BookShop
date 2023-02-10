package bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_cost")
    private float totalCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Book book;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orders")
    @JoinColumn(name = "id")
    private List<Orders> orders;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", totalCost=" + totalCost +
                '}';
    }
}
