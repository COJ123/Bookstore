package bookstore.services.author;

import bookstore.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    void saveAuthor(Author author);
    Author findById(int id);
    List<Author> findAllAuthors();
    void deleteAuthor(int id);
}
