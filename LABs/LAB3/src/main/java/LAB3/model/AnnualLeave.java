package LAB3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@DiscriminatorValue(value = LeaveType.Values.ANNUAL)
public class AnnualLeave extends Leave {
    private int daysAllowed = 15;

    public AnnualLeave(Employee emp, boolean approved, String remarks, LocalDate start, LocalDate end) {
        super(emp, approved, remarks, start, end);
    }
}
