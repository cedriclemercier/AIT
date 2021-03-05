package LAB3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)

// Provide cache strategy
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;

    private boolean active;

    // Note to Self
    // OneToMany: LAZY
    // ManyToMany: LAZY
    // ManyToOne: EAGER
    // OneToOne: EAGER

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Employee emp;

    // When you load employee it will load user (for one to one) by default
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @JsonIgnore
    @MapsId
    private Employee emp;

    public User(String username, String password, boolean active, String role, Employee emp) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
        this.emp = emp;
    }

}
