package ignatProject.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_ganre_id")
    private BookGanre bookGanre;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private List<Review> reviews;

    @Column(name = "rating")
    private int rating;

    @Column(name = "usersvote")
    private int usersvote;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookGanre getBookGanre() {
        return bookGanre;
    }

    public void setBookGanre(BookGanre bookGanre) {
        this.bookGanre = bookGanre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUsersvote() {
        return usersvote;
    }

    public void setUsersvote(int usersvote) {
        this.usersvote = usersvote;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && quantity == book.quantity && rating == book.rating && usersvote == book.usersvote && Objects.equals(supplier, book.supplier) && Objects.equals(name, book.name) && Objects.equals(bookGanre, book.bookGanre) && Objects.equals(description, book.description) && Objects.equals(imageUrl, book.imageUrl) && Objects.equals(author, book.author) && Objects.equals(price, book.price) && Objects.equals(reviews, book.reviews);
    }*/

    /*@Override
    public int hashCode() {
        return Objects.hash(id, supplier, name, bookGanre, description, imageUrl, author, price, quantity, reviews, rating, usersvote);
    }*/

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", name='" + name + '\'' +
                ", bookGange=" + bookGanre +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", quantity=" + quantity +
                ", reviews=" + reviews +
                ", rating=" + rating +
                ", usersvote=" + usersvote +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;

        return id == book.getId();
    }
    public int hashCode() {
        return Objects.hash(id);
    }

}
