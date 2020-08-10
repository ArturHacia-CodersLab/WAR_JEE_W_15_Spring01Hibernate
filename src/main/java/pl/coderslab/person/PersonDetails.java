package pl.coderslab.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = PersonDetails.TABLE)
public class PersonDetails {
    public final static String TABLE = "person_details";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;
}
