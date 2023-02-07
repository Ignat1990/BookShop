package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "name_book")
    String nameBook;
    @Column(name="author")
    String author;
    @Column(name = "book_gnre_id")
    String bookGanreId;
    @Column(name = "price")
    float price;
    @Column(name = "rating")
    int rating;
    @Column(name = "review")
    String review;

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

    public String getBookGanreId() {
        return bookGanreId;
    }

    public void setBookGanreId(String bookGanreId) {
        this.bookGanreId = bookGanreId;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                ", bookGanreId='" + bookGanreId + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
