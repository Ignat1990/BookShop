package ignatProject.repository;

import ignatProject.bean.Book;
import ignatProject.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
}

