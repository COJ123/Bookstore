package bookstore.controller;

import bookstore.entity.Author;
import bookstore.entity.Book;
import bookstore.entity.Genre;
import bookstore.entity.Order;
import bookstore.services.author.AuthorService;
import bookstore.services.book.BookService;
import bookstore.services.genre.GenreService;
import bookstore.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping ("/bookstoreEditor")
public class AdminInterfaceController {

    @Autowired
    BookService bookService;

    @Autowired
    GenreService genreService;

    @Autowired
    AuthorService authorService;

    @Autowired
    OrderService orderService;


    @GetMapping("/list")
    public String listBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "book-list-editor";
    }

    @GetMapping("/AddForm")
    public String AddForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @GetMapping("/AddAuthor")
    public String AddAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author-form";
    }

    @GetMapping("/AddGenre")
    public String AddGenre(Model model){
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "genre-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/bookstoreEditor/list";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.saveAuthor(author);
        return "redirect:/bookstoreEditor/list";
    }

    @PostMapping("/saveGenre")
    public String saveGenre(@ModelAttribute("genre") Genre genre){
        genreService.saveGenre(genre);
        return "redirect:/bookstoreEditor/list";
    }

    @GetMapping("/updateForm")
    public String UpdateForm(@RequestParam("bookTitle") String title,
                                    Model theModel)
    {
        Book book = bookService.getByTitleTest(title);
        theModel.addAttribute("book", book);

        return "book-form";
    }

    @GetMapping("/deleteBook")
    public String delete(@RequestParam("bookId") int theId,
                         Model theModel)
    {
        bookService.deleteBook(theId);
        return "redirect:/bookstoreEditor/list";
    }

    @GetMapping("/list-orders")
    public String listGenres(Model model){
        List<Order> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        return "orders-list";
    }

    @ModelAttribute("genres")
    public List<Genre> initializeGenres() {
        return genreService.findAllGenres();
    }

    @ModelAttribute("authors")
    public List<Author> initializeAuthors() {
        return authorService.findAllAuthors();
    }

}
