package wesley.calmmoment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wesley.calmmoment.model.OpenAnswer;
import wesley.calmmoment.repositories.OpenAnswerRepository;

import java.util.List;

@Service
public class OpenAnswerService {
    @Autowired
    private OpenAnswerRepository openAnswerRepository;

    public List<OpenAnswer> getOpenAnswers() {
        return openAnswerRepository.findAll();
    }
}
