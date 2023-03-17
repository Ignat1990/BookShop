package ignatProject.service;


import ignatProject.model.Book;

import java.util.List;


    public interface BookService {



            List<Book> findAll();

            boolean deleteBook(Long id);

            boolean saveBook(Book id);

            void updateBook(Long id, Book product);

            long bookCount();

            List<Book> findAllByBookGanreId(long bookId);

            List<Book> findAllByOrderByIdAsc();

            Book findById(long id);

            long count();
        }



/*    List<Book> findAll();

    boolean deleteBook(Long id);

    boolean saveProduct(Book id);

    boolean deleteBook(Long productId);

    void updateBook(Long id, Book product);

    long productsCount();

    List<Book> findAllByBookGanreId(long bookrGanreId);

    List<Book> findAllByCategoryId(long categoryId);

    List<Book> findAllByOrderByIdAsc();

    Book findById(long id);*/

/*
    long count();
}

*/

