package ignatProject.repository;

import ignatProject.model.BookGanre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGanreRepository extends JpaRepository<BookGanre, Long> {

    BookGanre findByName(String name);


}