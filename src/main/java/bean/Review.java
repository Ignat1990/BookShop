package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "book_id")
    int bookId;
    @Column(name = "user_id")
    int userId;
    @Column(name = "review")
    String review;
    @Column(name = "rating_book")
    int ratingBook;


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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRatingBook() {
        return ratingBook;
    }

    public void setRatingBook(int ratingBook) {
        this.ratingBook = ratingBook;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", review='" + review + '\'' +
                ", ratingBook=" + ratingBook +
                '}';
    }

}
