package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

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

    public Book findWithAuthorsById(long id) {
        Book book = bookDao.findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
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

    public List<Book> getAllWithAuthors() {
        List<Book> books = bookDao.getAll();
        books.stream().forEach(book -> Hibernate.initialize(book.getAuthors()));
        return books;
    }

    public List<Book> getRatingList(int rating) {
        return bookDao.getRatingList(rating);
    }

    public List<Book> getBookWithPublisher() {
        return bookDao.getBookWithPublisher();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        return bookDao.getBookWithPublisher(publisher);
    }

    public List<Book> getBookWithAuthor(Author author) {
        return bookDao.getBookWithAuthor(author);
    }

    public void deleteBooksForPublisher(Publisher publisher) {
        bookDao.deleteBooksForPublisher(publisher);
    }

    public void addAuthor(Book book, Author author) {
        List<Author> authors = book.getAuthors();
        authors.add(author);
    }
}
