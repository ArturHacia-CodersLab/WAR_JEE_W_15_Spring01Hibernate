package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
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

    @ModelAttribute("authors")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/form")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/form")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/form";
        }
        bookService.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        Book book = bookService.findWithAuthorsById(id);
        if (book == null) {
            return "error";
        }
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/edit/{id}")
    public String saveEditBook(@PathVariable long id, @Valid Book book, BindingResult result) {
        if (book.getId() != id) {
            return "error";
        }
        if (result.hasErrors()) {
            return "book/form";
        }
        bookService.update(book);
        return "redirect:/book/all";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "error";
        }
        model.addAttribute("book", book);
        return "book/confirm";
    }

}
