package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.MultipleChoiceAnswer;
import wesley.calmmoment.repositories.MultipleChoiceAnswerRepository;

import java.util.List;

@Service
public class MultipleChoiceAnswerService {
    @Autowired
    private MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;

    public List<MultipleChoiceAnswer> getMultipleChoiceAnswers() {
        return multipleChoiceAnswerRepository.findAll();
    }
}
