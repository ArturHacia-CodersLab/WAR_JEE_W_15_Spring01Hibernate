package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthorService {
    private final AuthorDao authorDao;

    public void saveAuthor(Author author) {
        authorDao.save(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }

    public List<Author> getAllWithBooks() {
        List<Author> authors = authorDao.getAll();
        authors.stream()
                .forEach(author -> Hibernate.initialize(author.getBooks()));
        return authors;
    }
}
