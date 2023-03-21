package ignatProject.controllers;


import ignatProject.model.Book;
import ignatProject.model.BookGanre;
import ignatProject.repository.BookGanreRepository;
import ignatProject.service.impl.BookGanreServiceImpl;
import ignatProject.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BookGanreServiceImpl bookGanreServiceImpl;

    @Autowired
    private BookGanreRepository bookGanreRepository;

    @Autowired
    protected BookServiceImpl bookServiceImpl;


    @GetMapping(value = {"/", "/index", "/home"})
    public String home(Model model) {
        model.addAttribute("books", bookServiceImpl.findAll());
        model.addAttribute("bookCount", bookServiceImpl.bookCount());
        model.addAttribute("bookGanres", bookGanreServiceImpl.findAll());
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String about() {

        return "about";
    }


    @RequestMapping("/searchByBookGanre/{id}")
    public String homePost(@PathVariable("id") long bookGanreId, Model model) {
        BookGanre bookGanre = bookGanreRepository.findById(bookGanreId).get();
        model.addAttribute("bookBookGanre", bookServiceImpl.findAllByBookGanreId(bookGanreId));
        model.addAttribute("bookCount", bookServiceImpl.bookCount());
        model.addAttribute("bookGanre", bookGanre);
        return "bookfrombookganre";
    }

    private List<Book> getAllBook() {
        return bookServiceImpl.findAllByOrderByIdAsc();
    }

    private long bookCount() {
        return bookServiceImpl.bookCount();
    }

}
