package bookstore.dao.author;

import bookstore.entity.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAuthors();
    void saveAuthor(Author author);
    Author findById(int id);
    List<Author> findAllAuthors();
    void deleteAuthor(int id);
}
