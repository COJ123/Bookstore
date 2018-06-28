package bookstore.converter;

import bookstore.entity.Author;
import bookstore.services.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdToEntityAuthorConverter implements Converter<Object, Author> {

    @Autowired
    AuthorService authorService;

    public Author convert(Object element) {
        Author author;
        try {
        Integer id = Integer.parseInt((String) element);
        author = authorService.findById(id);
        System.out.println("Author : " + author);
        } catch (NumberFormatException e) {
            author = new Author((String) element);
        }
        return author;
    }

}

