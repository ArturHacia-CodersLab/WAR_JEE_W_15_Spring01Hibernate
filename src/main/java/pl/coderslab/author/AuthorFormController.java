package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.book.Book;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/author")
public class AuthorFormController {
    private final AuthorService authorService;

    @GetMapping("/form")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping("/form")
    public String saveAuthor(@Valid Author author, BindingResult resutl) {
        if (resutl.hasErrors()) {
            return "author/form";
        }
        authorService.saveAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "error";
        }
        model.addAttribute("author", author);
        return "author/form";
    }

    @PostMapping("/edit/{id}")
    public String saveEditAuthor(@Valid Author author, BindingResult result, @PathVariable long id) {
        if (id != author.getId()) {
            return "error";
        }
        if (result.hasErrors()) {
            return "author/form";
        }
        authorService.update(author);
        return "redirect:/author/all";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "error";
        }
        model.addAttribute("author", author);
        return "author/confirm";
    }
}
