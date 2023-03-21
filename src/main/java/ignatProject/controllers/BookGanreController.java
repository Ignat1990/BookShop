package ignatProject.controllers;


import ignatProject.model.BookGanre;
import ignatProject.repository.BookGanreRepository;
import ignatProject.service.BookGanreService;
import ignatProject.service.impl.BookGanreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/bookGanre")

public class BookGanreController {
    @Autowired
    protected BookGanreServiceImpl bookGanreServiceImpl;

    @Autowired
    protected BookGanreRepository bookGanreRepository;

    @GetMapping
    public String viewBookGanre(Model model) {
        model.addAttribute("allBookGanre", bookGanreServiceImpl.findAll());
        /*model.addAttribute("newBookGanreForm", new BookGanre());*/
        return "admin/bookganre/bookGanre";
    }

    @PostMapping
    public String newBookGanre(@ModelAttribute("newBookGanreForm") BookGanre newBookGanreForm, Model model) {

        if (!bookGanreServiceImpl.saveBookGanre(newBookGanreForm)) {
            model.addAttribute("bookGanreError", "This book ganre is taken");
            return "admin/bookganre/bookGanre";
        }
        return "redirect:/admin/bookGanre";

    }

    @GetMapping("/delete/{id}")
    public String deleteBookGanre(@PathVariable("id") long id) {
        bookGanreServiceImpl.deleteBookGanre(id);
        return "redirect:/admin/bookGanre";
    }

    @GetMapping("/edit/{id}")
    public String editBookGanre(@PathVariable("id") long id, Model model) {
        if (!bookGanreRepository.existsById(id)) {
            return "redirect:admin/bookGanre";
        }
        BookGanre bookGanre = bookGanreRepository.findById(id).get();
        ArrayList<BookGanre> editBookGanre = new ArrayList<>();
        editBookGanre.add(bookGanre);
        model.addAttribute("editbookGanre", editBookGanre);
        return "admin/bookganre/editbookGanre";
    }

    @PostMapping("/edit/{id}")
    public String updateBookGanre(@PathVariable("id") long id, @RequestParam String name, Model model) {
        BookGanre bookGanre = bookGanreRepository.findById(id).get();
        bookGanre.setName(name);
        bookGanreRepository.save(bookGanre);
        return "redirect:/admin/bookGanre";
    }

}

