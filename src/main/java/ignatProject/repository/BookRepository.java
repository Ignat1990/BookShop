package ignatProject.repository;


import ignatProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

    List<Book> findAllByBookGanre_Id(Long bookGanreId);

    List<Book> findAllByOrderByIdAsc();


}
