package ignatProject.service.impl;


import ignatProject.model.Author;
import ignatProject.repository.AuthorRepository;
import ignatProject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    protected AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }


    @Override
    public boolean saveAuthor(Author author) {
        Author authorFromDB = authorRepository.findByName(author.getName());

        if (authorFromDB != null) {
            return false;
        }
        authorRepository.save(author);
        return true;
    }

    @Override
    public boolean deleteAuthor(Long manufacturerId) {
        if (authorRepository.findById(manufacturerId).isPresent()) {
            authorRepository.deleteById(manufacturerId);
            return true;
        }
        return false;
    }

}
