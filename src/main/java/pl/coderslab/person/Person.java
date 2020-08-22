package pl.coderslab.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = Person.TABLE)
public class Person {
    public final static String TABLE = "persons";
    private final static String PERSON_DETAIL_COLUMN = "detail_id";

    public Person(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = PERSON_DETAIL_COLUMN, unique=true)
    private PersonDetails personDetails;
}
