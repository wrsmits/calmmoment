package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
