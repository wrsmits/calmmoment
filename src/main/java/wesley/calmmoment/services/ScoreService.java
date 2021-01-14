package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.Score;
import wesley.calmmoment.repositories.ScoreRepository;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScores() {
        return scoreRepository.findAll();
    }
}
