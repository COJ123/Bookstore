package bookstore.converter;

import bookstore.entity.Genre;
import bookstore.services.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdToEntityGenreConverter implements Converter<Object, Genre> {

    @Autowired
    GenreService genreService;

    public Genre convert(Object element) {
        Genre genre;
        try {
        Integer id = Integer.parseInt((String) element);
        genre = genreService.findById(id);
        System.out.println("Genre : " + genre);
        } catch (NumberFormatException e) {
            genre = new Genre((String) element);
        }
        return genre;
    }

}

