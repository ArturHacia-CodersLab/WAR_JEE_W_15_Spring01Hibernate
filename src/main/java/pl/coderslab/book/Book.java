package pl.coderslab.book;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = Book.TABLE)
public class Book {
    public final static String TABLE = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;

    public Book() {
        authors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
