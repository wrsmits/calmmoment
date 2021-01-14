package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.MultipleChoiceQuestion;
import wesley.calmmoment.repositories.MultipleChoiceQuestionRepository;

import java.util.List;

@Service
public class MultipleChoiceQuestionService {
    @Autowired
    private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;

    public List<MultipleChoiceQuestion> getMultipleChoiceQuestions() {
        return multipleChoiceQuestionRepository.findAll();
    }
}
