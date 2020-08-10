package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;

@RequiredArgsConstructor
@Controller
public class PublisherController {
    private final PublisherService publisherService;

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String savePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Helios");
        publisherService.savePublisher(publisher);
        return "dodano wydawcę";
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherService.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id ) {
        Publisher publisher = publisherService.findById(id);
        publisher.setName("PWN");
        publisherService.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherService.findById(id);
        publisherService.delete(publisher);
        return "deleted";
    }
}
