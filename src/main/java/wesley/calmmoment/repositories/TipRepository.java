package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long> {
}
