package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/book/all")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book/all";
    }

    @RequestMapping("/book/all/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable int rating) {
        return bookService.getRatingList(rating).toString();
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String saveBook() {
        Author author1 = authorService.findById(1);
        Author author2 = authorService.findById(2);

        Publisher publisher = new Publisher();
        publisher.setName("Helios");
        publisherService.savePublisher(publisher);

        Book book = new Book();
        book.setTitle("Czas Horusa");
        book.setRating(7);
        book.setDescription("Warhammer 40k");
        book.setPublisher(publisher);
        bookService.addAuthor(book, author1);
        bookService.addAuthor(book, author2);
        bookService.saveBook(book);
        return "dodano książkę";
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id ) {
        Book book = bookService.findById(id);
        book.setDescription("Warhammer 40k (wersja II)");
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }

    @RequestMapping("/book/all/publisher")
    @ResponseBody
    public String getBookWithPublisher() {
        return bookService.getBookWithPublisher().toString();
    }

    @RequestMapping("/book/all/publisher/{id}")
    @ResponseBody
    public String getBookWithPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "Nie ma takiego wydawcy";
        }
        return bookService.getBookWithPublisher(publisher).toString();
    }

    @RequestMapping("/book/all/author/{id}")
    @ResponseBody
    public String getBookWithAuthor(@PathVariable int id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "Nie ma takiego autora";
        }
        return bookService.getBookWithAuthor(author).toString();
    }
}
