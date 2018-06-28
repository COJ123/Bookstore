package bookstore.services.genre;

import bookstore.dao.genre.GenreDao;
import bookstore.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImp implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override

    public List<Genre> getGenres() {
        return genreDao.getGenres();
    }

    @Override

    public void saveGenre(Genre genre) {
        genreDao.saveGenre(genre);
    }

    @Override
    public Genre findById(int id) {
        return genreDao.findById(id);
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreDao.findAllGenres();
    }

    @Override
    public void delteGenre(int id) {
        genreDao.delteGenre(id);
    }
}
