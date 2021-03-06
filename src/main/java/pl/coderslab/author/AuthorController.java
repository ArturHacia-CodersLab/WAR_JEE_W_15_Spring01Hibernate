package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;

@RequiredArgsConstructor
@Controller
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/author/all")
    public String getAll(Model model) {
        model.addAttribute("authors", authorService.getAllWithBooks());
        return "author/all";
    }

    @RequestMapping("/author/add")
    @ResponseBody
    public String saveAuthor() {
        Author author = new Author();
        author.setFirstName("Artur");
        author.setLastName("Hacia");
        authorService.saveAuthor(author);
        return "dodano autora";
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id ) {
        Author author = authorService.findById(id);
        author.setFirstName("Artur 2");
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "error";
        }
        authorService.delete(author);
        return "redirect:/author/all";
    }
}
