package medicine.com.bpgback.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="client_cards")
@AllArgsConstructor
@Data
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column
    private String patronymic;

    @Column(nullable = false)
    private Integer age;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(nullable = false, length = 2000)
    private String complaint;

    @Column(length = 2000)
    private String advanceDiagnosis;

    @Column(nullable = false, length = 2000)
    private String appointment;

    @Column(nullable = false, name = "creation_date")
    private Date creationDate;

    @Column(nullable = false, name = "modification_date")
    private Date modificationDate;

}
