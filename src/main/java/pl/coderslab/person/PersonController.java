package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;
import pl.coderslab.publisher.Publisher;

@RequiredArgsConstructor
@Controller
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person/form";
    }

    @PostMapping("/person/add")
    @ResponseBody
    public String savePerson(@ModelAttribute Person person) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Artur");
        personDetails.setLastName("Hacia");
        personDetails.setStreetNumber("59");
        personDetails.setStreet("Prosta");
        personDetails.setCity("Warszawa");

        //Person person = new Person(login, password, email);
        person.setPersonDetails(personDetails);

        personService.savePerson(person);
        return "dodano osobę";
    }

    @RequestMapping("/person/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/person/update/{id}")
    @ResponseBody
    public String updatePerson(@PathVariable long id ) {
        Person person = personService.findById(id);
        person.setLogin("artur2.hacia2");
        person.getPersonDetails().setFirstName("Artur2");
        person.getPersonDetails().setLastName("Hacia2");
        personService.update(person);
        return person.toString();
    }

    @RequestMapping("/person/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        Person person = personService.findById(id);
        personService.delete(person);
        return "deleted";
    }
}
