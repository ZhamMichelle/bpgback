package medicine.com.bpgback.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
public class ClientCardDTO {
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private String phoneNumber;
    private String complaint;
    private String advanceDiagnosis;
    private String appointment;

}
