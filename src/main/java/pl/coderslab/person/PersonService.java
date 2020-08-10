package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class PersonService {
    private final PersonDao personDao;

    public void savePerson(Person person) {
        personDao.save(person);
    }

    public Person findById(long id) {
        return personDao.findById(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(Person person) {
        personDao.delete(person);
    }
}
