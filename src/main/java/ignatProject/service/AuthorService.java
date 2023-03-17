package ignatProject.service;

import ignatProject.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();


    boolean saveAuthor(Author author);

    boolean deleteAuthor(Long manufacturerId);
}

