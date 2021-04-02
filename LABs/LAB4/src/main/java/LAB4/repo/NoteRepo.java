package LAB4.repo;

import LAB4.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Notes, Integer> {

}