package service.lmpl;

import bean.Basket;
import bean.Book;
import bean.Orders;
import org.springframework.stereotype.Service;
import repository.BasketRepository;
import repository.BookRepository;
import service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final
    BasketRepository basketRepository;
    final
    BookRepository bookRepository;

    public BookServiceImpl(BasketRepository basketRepository, BookRepository bookRepository) {
        this.basketRepository = basketRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getOne(id);
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    @Override
    public String toString() {
        return "BookServiceImpl{" +
                "basketRepository=" + basketRepository +
                ", bookRepository=" + bookRepository +
                '}';
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);



    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }
    public Book findBook(Orders orders){
        Basket basket = basketRepository.getOne(orders.getId());
        return bookRepository.getOne(basket.getBook().getId());
    }
}
