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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookstore")
public class BookStoreController {

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
        return "book-list";
    }

    @GetMapping("/listByAuthors")
    public String listAuthors(Model model){
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "byAuthors-list";
    }

    @GetMapping("/listByGenres")
    public String listGenres(Model model){
        List<Genre> genres = genreService.getGenres();
        model.addAttribute("genres", genres);
        return "byGenres-list";
    }

    @GetMapping("/purchase")
    public String purchase(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "order-form";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order){
        orderService.saveOrder(order);
        return "redirect:/bookstore/list";
    }

    @ModelAttribute("books")
    public List<Book> initializeBooks() {
        return bookService.findAllBook();
    }
}
