package ignatProject.service;

import ignatProject.model.Book;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {


    void addBook(Book book);

    void removeBook(Book book);

    void clearBooks();

    Map<Book, Integer> booksInCart();

    BigDecimal totalPrice();

    void cartCheckout();

}



