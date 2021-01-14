package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.OpenQuestion;

@Repository
public interface OpenQuestionRepository extends JpaRepository<OpenQuestion, Long> {
}
