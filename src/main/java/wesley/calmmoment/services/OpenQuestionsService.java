package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.OpenQuestion;
import wesley.calmmoment.repositories.OpenQuestionRepository;

import java.util.List;

@Service
public class OpenQuestionsService {
    @Autowired
    private OpenQuestionRepository openQuestionRepository;

    public List<OpenQuestion> getOpenQuestions() {
        return openQuestionRepository.findAll();
    }
}
