package CitizenService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int citizen_id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "citizen_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "citizen_last_name"))
    })
    private Name name;

    private int occupation_id;

    private int bank_account_no;
}
