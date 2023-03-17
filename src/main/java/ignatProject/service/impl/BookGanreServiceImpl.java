package ignatProject.service.impl;




import ignatProject.model.BookGanre;
import ignatProject.repository.BookGanreRepository;
import ignatProject.service.BookGanreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookGanreServiceImpl implements BookGanreService {

    @Autowired
    protected BookGanreRepository bookGanreRepositiry;

    @Override
    public List<BookGanre> findAll() {
        return bookGanreRepositiry.findAll();
    }





    @Override
    public boolean saveBookGanre(BookGanre bookGanre) {
        BookGanre bookGanreFromDB = bookGanreRepositiry.findByName(bookGanre.getName());

        if (bookGanreFromDB != null) {
            return false;
        }
        bookGanreRepositiry.save(bookGanre);
        return true;
    }

    @Override
    public boolean deleteBookGanre(Long bookGanreId) {
        if (bookGanreRepositiry.findById(bookGanreId).isPresent()) {
            bookGanreRepositiry.deleteById(bookGanreId);
            return true;
        }
        return false;
    }

}
