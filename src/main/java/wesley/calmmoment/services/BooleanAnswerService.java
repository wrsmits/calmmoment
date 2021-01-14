package wesley.calmmoment.services;

import wesley.calmmoment.model.BooleanAnswer;
import wesley.calmmoment.repositories.BooleanAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooleanAnswerService {
    @Autowired
    private BooleanAnswerRepository booleanAnswerRepository;

    public List<BooleanAnswer> getBooleanAnswers() {
        return booleanAnswerRepository.findAll();
    }
}
