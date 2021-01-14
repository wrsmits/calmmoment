package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.BooleanAnswer;

@Repository
public interface BooleanAnswerRepository extends JpaRepository<BooleanAnswer, Long> {
}
