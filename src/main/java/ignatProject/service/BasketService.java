package ignatProject.service;



import ignatProject.model.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BasketService {


    void addBook(Book book);


    void removeBook(Book book);

    void clearBook();

    Map<Book, Integer> booksInCart();

    BigDecimal totalPrice();

    void cartCheckout();

    List<BasketService> findAllByOrder_id(long id);
}

/*

public interface BasketService {

    void addBook(Basket basket);

    void removeProduct();

    void clearBook();

    Map<Basket, Integer> BooksInCart();

    BigDecimal totalPrice();

    void cartCheckout();

    void deleteBasket(Long id);

    Basket getBasket(Long id);
    List<Basket> findAllByOrder_id(long id);
}*/
