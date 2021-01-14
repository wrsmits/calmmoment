package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.OpenAnswer;

@Repository
public interface OpenAnswerRepository extends JpaRepository<OpenAnswer, Long> {
}
