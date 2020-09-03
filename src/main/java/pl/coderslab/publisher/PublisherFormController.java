package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.Book;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/publisher")
public class PublisherFormController {
    private final PublisherService publisherService;

    @GetMapping("/form")
    public String addPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/form";
    }

    @PostMapping("/form")
    public String savePublisher(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publisher/form";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/edit/{id}")
    public String editPublisher(@PathVariable long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "error";
        }
        model.addAttribute("publisher", publisher);
        return "publisher/form";
    }

    @PostMapping("/edit/{id}")
    public String saveEditPublisher(@PathVariable long id, @Valid Publisher publisher, BindingResult result) {
        if (publisher.getId() != id) {
            return "error";
        }
        if (result.hasErrors()) {
            return "/publisher/form";
        }
        publisherService.update(publisher);
        return "redirect:/publisher/all";
    }

    @RequestMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "error";
        }
        model.addAttribute("publisher", publisher);
        return "publisher/confirm";
    }
}
