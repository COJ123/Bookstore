package bookstore.services.author;

import bookstore.dao.author.AuthorDao;
import bookstore.dao.book.BookDao;
import bookstore.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override

    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }

    @Override
    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    @Override
    public Author findById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }

    @Override
    public void deleteAuthor(int id) {
        authorDao.deleteAuthor(id);
    }
}
