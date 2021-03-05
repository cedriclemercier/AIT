package LAB3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Benefit {

    public Benefit(String title, Set<Employee> emp) {
        super();
        this.title = title;
        this.emp = emp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    // When loading benefits, it will not load employees by default
    @ManyToMany(mappedBy = "benefits")
    // Let the other side create the association table
    // Set has better performance than List in many-to-many
    private Set<Employee> emp;

}
