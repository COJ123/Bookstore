package bookstore.controller.rest;

import bookstore.entity.Author;
import bookstore.entity.Book;
import bookstore.entity.Genre;
import bookstore.services.author.AuthorService;
import bookstore.services.book.BookService;
import bookstore.services.genre.GenreService;
import bookstore.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookstoreRestController {
    @Autowired
    BookService bookService;

    @Autowired
    GenreService genreService;

    @Autowired
    AuthorService authorService;

    @Autowired
    OrderService orderService;

    // BOOK**********************************

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        return bookService.getById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        book.setId(0);
        bookService.saveBook(book);
        return book;
    }
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){

        bookService.saveBook(book);
        return book;
    }
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId){

        bookService.deleteBook(bookId);
        return bookId + "deleted";
    }

    //AUTHOR********************************

    @GetMapping("/authors")
    public List<Author> getAuthor(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthor(@PathVariable int authorId){
        return authorService.findById(authorId);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author){
        author.setId(0);
        authorService.saveAuthor(author);
        return author;
    }
    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author){
        authorService.saveAuthor(author);
        return author;
    }
    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthor(@PathVariable int authorId){
        authorService.deleteAuthor(authorId);
        return authorId + "deleted";
    }

    //GENRE ***********************

    @GetMapping("/genres")
    public List<Genre> getGenre(){
        return genreService.getGenres();
    }

    @GetMapping("/genres/{genreId}")
    public Genre getGenre(@PathVariable int genreId){
        return genreService.findById(genreId);
    }

    @PostMapping("/genres")
    public Genre addGenre(@RequestBody Genre genre){
        genre.setId(0);
        genreService.saveGenre(genre);
        return genre;
    }
    @PutMapping("/genres")
    public Genre updateGenre(@RequestBody Genre genre){
        genreService.saveGenre(genre);
        return genre;
    }
    @DeleteMapping("/genres/{genreId}")
    public String deleteGenre(@PathVariable int genreId){
        genreService.delteGenre(genreId);
        return genreId + "deleted";
    }
}
