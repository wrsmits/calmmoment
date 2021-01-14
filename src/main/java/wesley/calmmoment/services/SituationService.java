package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.Situation;
import wesley.calmmoment.repositories.SituationRepository;

import java.util.List;

@Service
public class SituationService {
    @Autowired
    private SituationRepository situationRepository;

    public List<Situation> getSituations() {
        return situationRepository.findAll();
    }

    public Situation getSituation(Long situationId) {
        return situationRepository.findById(situationId).orElse(null);
    }
}
