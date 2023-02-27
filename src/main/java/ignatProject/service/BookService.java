package ignatProject.service;


import ignatProject.bean.Book;
import ignatProject.bean.Orders;

import java.util.List;

    public interface BookService {
        public List<Book> getAllBooks();
        public Book getBookById(Long id);
        public void saveBook(Book book);
        public void deleteBook(Long id);
        public Book findBook(Orders order);
    }

