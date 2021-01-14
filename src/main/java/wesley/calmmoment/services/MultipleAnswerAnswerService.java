package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.MultipleAnswerAnswer;
import wesley.calmmoment.repositories.MultipleAnswerAnswerRepository;

import java.util.List;

@Service
public class MultipleAnswerAnswerService {
    @Autowired
    private MultipleAnswerAnswerRepository multipleAnswerAnswerRepository;

    public List<MultipleAnswerAnswer> getMultipleAnswerAnswers() {
        return multipleAnswerAnswerRepository.findAll();
    }
}
