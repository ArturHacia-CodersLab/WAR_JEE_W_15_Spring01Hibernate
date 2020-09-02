package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.author.validator.IsAdult;
import pl.coderslab.book.Book;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @PESEL
    @Column(length = 11)
    private String pesel;

    @Email
    private String email;

    @IsAdult
    private Integer yearOfBirth;

    public Author() {
        books = new ArrayList<>();
    }

    public String getFullName() {
        return firstName + " " + lastName;
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
