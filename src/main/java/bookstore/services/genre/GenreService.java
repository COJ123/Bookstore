package bookstore.services.genre;

import bookstore.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();
    void saveGenre(Genre genre);
    Genre findById(int id);
    List<Genre> findAllGenres();
    void delteGenre(int id);
}
