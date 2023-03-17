package ignatProject.service.impl;


import ignatProject.model.Book;
import ignatProject.repository.BookRepository;
import ignatProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    protected BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean saveBook(Book book) {
        Book bookFromDB = bookRepository.findByName(book.getName());

        if (bookFromDB != null) {
            return false;
        }
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean deleteBook(Long bookId) {
        if (bookRepository.findById(bookId).isPresent()) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    @Override
    public void updateBook(Long id, Book book) {
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public long bookCount() {
        return bookRepository.count();
    }

    @Override
    public List<Book> findAllByBookGanreId(long bookGanreId) {
        return bookRepository.findAllByBookGange_Id(bookGanreId);
    }

    @Override
    public List<Book> findAllByOrderByIdAsc() {
        return bookRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}




/*
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

*/
