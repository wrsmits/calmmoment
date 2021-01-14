package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.BooleanQuestion;

@Repository
public interface BooleanQuestionRepository extends JpaRepository<BooleanQuestion, Long> {
}
