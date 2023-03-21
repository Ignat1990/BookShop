package ignatProject.controllers;

import ignatProject.model.Author;
import ignatProject.repository.AuthorRepository;
import ignatProject.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


    @Controller
    @RequestMapping("/admin/author")
    public class AuthorController {

        @Autowired
        protected AuthorServiceImpl authorServiceImpl;

        @Autowired
        protected AuthorRepository authorRepository;

        @GetMapping
        public String viewAuthor(Model model) {
            model.addAttribute("allAuthors", authorServiceImpl.findAll());
            model.addAttribute("newAuthorForm", new Author());
            return "admin/author/author";
        }

        @PostMapping
        public String newAuthor(@ModelAttribute("newAuthorForm") Author newAuthorForm, Model model) {

            if (!authorServiceImpl.saveAuthor(newAuthorForm)) {
                model.addAttribute("authorError", "This name is taken");
                return "admin/author/author";
            }
            return "redirect:/admin/author";
        }

        @GetMapping("/delete/{id}")
        public String deleteAuthor(@PathVariable("id") long id) {
            authorServiceImpl.deleteAuthor(id);
            return "redirect:/admin/author";
        }

        @GetMapping("/edit/{id}")
        public String editAuthor(@PathVariable("id") long id, Model model) {
            if (!authorRepository.existsById(id)) {
                return "redirect:admin/author";
            }
            Author author = authorRepository.findById(id).get();
            ArrayList<Author> editAuthor = new ArrayList<>();
            editAuthor.add(author);
            model.addAttribute("editAuthor", editAuthor);
            return "admin/author/editauthor";
        }

        @PostMapping("/edit/{id}")
        @Transactional
        public String updateAuthor(@PathVariable("id") long id, @RequestParam String name, Model model) {
            Author author = authorRepository.findById(id).get();
            author.setName(name);
            authorRepository.save(author);
            return "redirect:/admin/author";
        }

    }


