package bookstore.services.book;

import bookstore.entity.Author;
import bookstore.entity.Book;
import bookstore.entity.Genre;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void saveBook(Book book);
    Book getBook(int theId);
    void deleteBook(int theId);
    Book getById(int theId);
    Book getByTitleTest(String title);
    List<Book> findAllBook();
}
