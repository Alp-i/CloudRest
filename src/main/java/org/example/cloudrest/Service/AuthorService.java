package org.example.cloudrest.Service;

import org.example.cloudrest.Model.Author;
import org.example.cloudrest.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseThrow(()->new RuntimeException("Article not found"));
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author updatedAuthor) {
        authorRepository.save(updatedAuthor);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
