package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.MultipleAnswerQuestion;

@Repository
public interface MultipleAnswerQuestionRepository extends JpaRepository<MultipleAnswerQuestion, Long> {
}
