package wesley.calmmoment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wesley.calmmoment.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}
