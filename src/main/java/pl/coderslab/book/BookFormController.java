package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/book")
public class BookFormController {
    public final BookService bookService;
    public final AuthorService authorService;
    public final PublisherService publisherService;

    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers() {
        return publisherService.getAll();
    }

    @GetMapping("/form")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
    public String saveBook(@ModelAttribute Book book) {
        Author author = authorService.findById(1);
        bookService.addAuthor(book, author);
        bookService.saveBook(book);
        return "redirect:/book/all";
    }
}
