package Main.Service.dao;

import Main.Service.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationDao extends JpaRepository<Registration, Integer> {
}
