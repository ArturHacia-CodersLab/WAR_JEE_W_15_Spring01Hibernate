package pl.coderslab.publisher;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Entity
@Table(name = Publisher.TABLE)
public class Publisher {
    public final static String TABLE = "publishers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @NIP
    @Column(length = 10)
    private String nip;
    @REGON
    @Column(length = 9)
    private String regon;
}
