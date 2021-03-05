package LAB3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Name {
    private String fname;
    private String lname;
    private String mname;
}
