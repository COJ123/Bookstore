package bookstore.dao.book;

import bookstore.entity.Author;
import bookstore.entity.Book;
import bookstore.entity.Genre;

import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(int theId);
    void deleteBook(int theId);
    Book getById(int theId);
    Book getByTitleTest(String title);
    List<Book> findAllBook();
}
