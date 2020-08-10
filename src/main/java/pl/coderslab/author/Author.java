package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = Author.TABLE)
public class Author {
    public final static String TABLE = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
        books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
