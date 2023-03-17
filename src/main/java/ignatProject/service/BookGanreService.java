package ignatProject.service;


import ignatProject.model.BookGanre;

import java.util.List;

public interface BookGanreService {


        List<BookGanre> findAll();

        boolean deleteBookGanre(Long id);

        boolean saveBookGanre(BookGanre id);


    }
