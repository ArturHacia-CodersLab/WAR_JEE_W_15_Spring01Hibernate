package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BookService {
    private final BookDao bookDao;

    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public void addAuthor(Book book, Author author) {
        List<Author> authors = book.getAuthors();
        authors.add(author);
    }
}
