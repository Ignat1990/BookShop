package ignatProject.service.impl;


import ignatProject.model.Book;
import ignatProject.service.ShoppingCartService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Book, Integer> cart = new LinkedHashMap<>();

    @Override
    public void addBook(Book book) {
        if (cart.containsKey(book)) {
            cart.replace(book, cart.get(book) + 1);
        } else {
            cart.put(book, 1);
        }
    }

    @Override
    public void removeBook(Book book) {
        if (cart.containsKey(book)) {
            if (cart.get(book) > 1) {
                cart.replace(book, cart.get(book) - 1);
            } else if (cart.get(book) == 1) {
                cart.remove(book);

            }
        }
    }

    @Override
    public void clearBooks() {
        cart.clear();
    }

    @Override
    public Map<Book, Integer> booksInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public BigDecimal totalPrice() {
        return cart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void cartCheckout() {
        cart.clear();
    }

    public Map<Book, Integer> getCart() {
        return cart;
    }
}
