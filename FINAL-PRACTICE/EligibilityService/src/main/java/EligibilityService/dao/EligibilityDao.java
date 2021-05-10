package EligibilityService.dao;

import EligibilityService.model.Eligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EligibilityDao extends JpaRepository<Eligibility, Integer> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Eligibility c WHERE c.occupation_id = ?1")
    boolean findByOccupationId(int occupation_id);
}
