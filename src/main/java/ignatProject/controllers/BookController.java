package ignatProject.controllers;


import ignatProject.model.Author;
import ignatProject.model.Book;
import ignatProject.model.BookGanre;
import ignatProject.model.Order;
import ignatProject.repository.BookRepository;
import ignatProject.service.impl.AuthorServiceImpl;
import ignatProject.service.impl.BookGanreServiceImpl;
import ignatProject.service.impl.BookServiceImpl;
import ignatProject.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/book")
public class BookController {

    @Autowired
    protected BookServiceImpl bookServiceImpl;

    @Autowired
    protected BookGanreServiceImpl bookGanreServiceImpl;

    @Autowired
    protected AuthorServiceImpl authorServiceImpl;

    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected SupplierServiceImpl supplierServiceImpl;

    @GetMapping
    public String viewBooks(Model model) {
        model.addAttribute("allBooks", bookServiceImpl.findAll());
        return "admin/book/book";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("newBookForm", new Book());
        model.addAttribute("bookGanres", bookGanreServiceImpl.findAll());
        model.addAttribute("author", authorServiceImpl.findAll());
        model.addAttribute("supplier", supplierServiceImpl.findAll());

        return "admin/book/newbook";
    }

    @PostMapping("/new")
    public String createNewBook(@ModelAttribute("newBookForm") Book newBookForm, Model model) {
        /*System.out.println("New book=" + newBookForm);*/
        if (!bookServiceImpl.saveBook(newBookForm)) {
            model.addAttribute("bookNameError", "This name is taken");
            return "admin/book/newbook";
        }
        return "redirect:/admin/book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookServiceImpl.deleteBook(id);
        return "redirect:/admin/book";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:admin/book";
        }
        /*Book book = bookRepository.findById(id).get();
        ArrayList<Book> editBook = new ArrayList<>();
        editBook.add(book);*/
        model.addAttribute("editBook", bookRepository.findById(id).get());
        model.addAttribute("bookGanres", bookServiceImpl.findAll());
        model.addAttribute("author", authorServiceImpl.findAll());
        model.addAttribute("supplier", supplierServiceImpl.findAll());

        return "admin/book/editbook";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String updateBook(@PathVariable("id") long id, @ModelAttribute("editBook") Book editBook) {
        /*Book book = bookRepository.findById(id).get();
        bookRepository.save(book);*/
        bookServiceImpl.updateBook(id, editBook);
        return "redirect:/admin/book";
    }

}
