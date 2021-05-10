package CitizenService.dao;

import CitizenService.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "citizen", path = "citizen")
public interface CitizenDao extends JpaRepository<Citizen, Integer> {

    @Query("select c from Citizen c where c.citizen_id = ?1")
    Citizen findByCitizenId(int citizenId);
}
