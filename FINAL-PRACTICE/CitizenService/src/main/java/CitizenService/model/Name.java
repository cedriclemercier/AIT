package CitizenService.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {
    private String firstName;
    private String lastName;
}
