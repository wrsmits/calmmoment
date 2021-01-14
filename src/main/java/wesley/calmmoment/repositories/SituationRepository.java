package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation, Long> {
}
