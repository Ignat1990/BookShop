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
        return bookRepository.findAllByBookGanre_Id(bookGanreId);
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

