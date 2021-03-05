package LAB3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorColumn(name = "LEAVE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate start;
    private LocalDate end;
    String remarks;
    private boolean approved;

    @Column(name = "LEAVE_TYPE", nullable = false, insertable = false, updatable = false)
    // Only sickleave or annual leave will update or create this field
    @Enumerated(EnumType.STRING)
    public LeaveType leaveType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Employee emp;

    public Leave(Employee emp, boolean approved, String remarks, LocalDate start, LocalDate end) {
        super();
        this.emp = emp;
        this.approved = approved;
        this.remarks = remarks;
        this.start = start;
        this.end = end;
    }
}
