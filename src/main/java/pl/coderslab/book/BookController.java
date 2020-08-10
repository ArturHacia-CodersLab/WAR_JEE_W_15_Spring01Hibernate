package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
        book.setRating(8);
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
}
