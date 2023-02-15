package bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private float price;
    @Column(name = "rating")
    private int rating;
    @Column(name = "review")
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_ganre_id")
    private BookGanre bookGanre;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                ", bookGanre=" + bookGanre +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public BookGanre getBookGanre() {
        return bookGanre;
    }

    public void setBookGanre(BookGanre bookGanre) {
        this.bookGanre = bookGanre;
    }
}
