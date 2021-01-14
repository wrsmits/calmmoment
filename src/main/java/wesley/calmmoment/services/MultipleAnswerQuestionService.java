package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.MultipleAnswerQuestion;
import wesley.calmmoment.repositories.MultipleAnswerQuestionRepository;

import java.util.List;

@Service
public class MultipleAnswerQuestionService {
    @Autowired
    private MultipleAnswerQuestionRepository multipleAnswerQuestionRepository;

    public List<MultipleAnswerQuestion> getMultipleAnswerQuestions() {
        return multipleAnswerQuestionRepository.findAll();
    }
}
