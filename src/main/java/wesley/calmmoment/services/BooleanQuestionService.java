package wesley.calmmoment.services;

import org.springframework.stereotype.Service;
import wesley.calmmoment.model.BooleanQuestion;
import wesley.calmmoment.repositories.BooleanQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BooleanQuestionService {
    @Autowired
    private BooleanQuestionRepository booleanQuestionRepository;

    public List<BooleanQuestion> getBooleanQuestions() {
        return booleanQuestionRepository.findAll();
    }
}
