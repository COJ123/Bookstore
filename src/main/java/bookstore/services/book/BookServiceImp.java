package bookstore.services.book;

import bookstore.dao.book.BookDao;
import bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImp implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public Book getBook(int theId) {
        return bookDao.getBook(theId);
    }

    @Override
    public void deleteBook(int theId) {
        bookDao.deleteBook(theId);
    }

    @Override
    public Book getById(int theId) {
        return bookDao.getById(theId);
    }

    @Override
    public Book getByTitleTest(String title) {
        return bookDao.getByTitleTest(title);
    }

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }


}
