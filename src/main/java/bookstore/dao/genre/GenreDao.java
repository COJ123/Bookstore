package bookstore.dao.genre;

import bookstore.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getGenres();

    void saveGenre(Genre genre);

    Genre findById(int id);
    List<Genre> findAllGenres();
    void delteGenre(int id);
}