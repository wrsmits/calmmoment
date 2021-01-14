package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.MultipleAnswerAnswer;
import wesley.calmmoment.model.MultipleAnswerQuestion;
import wesley.calmmoment.services.MultipleAnswerAnswerService;
import wesley.calmmoment.services.MultipleAnswerQuestionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultipleAnswerAnswerController {

    @Autowired
    private MultipleAnswerAnswerService multipleAnswerAnswerService;

    @GetMapping("/multipleAnswerAnswers")
    public List<MultipleAnswerAnswerSimple> getMultipleAnswerAnswers() {
        List<MultipleAnswerAnswer> multipleAnswerAnswers = multipleAnswerAnswerService.getMultipleAnswerAnswers();
        List<MultipleAnswerAnswerSimple> multipleAnswerAnswerSimple = new ArrayList<MultipleAnswerAnswerSimple>();
        for (MultipleAnswerAnswer maa : multipleAnswerAnswers) {
            multipleAnswerAnswerSimple.add(new MultipleAnswerAnswerSimple(maa.getAnswerId(), maa.getAnswerName(), maa.getAnswerWriter(), maa.getAnswerGiven(), maa.getAnswerQuestion()));
        }

        return multipleAnswerAnswerSimple;
    }

    class MultipleAnswerAnswerSimple {
        private Long answerId;
        private String answerName;
        private AppUser answerWriter;
        private List<String> answerGiven;
        private MultipleAnswerQuestion answerQuestion;

        public MultipleAnswerAnswerSimple(Long answerId, String answerName, AppUser answerWriter, List<String> answerGiven, MultipleAnswerQuestion answerQuestion) {
            this.answerId = answerId;
            this.answerName = answerName;
            this.answerWriter = answerWriter;
            this.answerGiven = answerGiven;
            this.answerQuestion = answerQuestion;
        }

        public Long getAnswerId() {
            return answerId;
        }

        public String getAnswerName() {
            return answerName;
        }

        public AppUser getAnswerWriter() {
            return answerWriter;
        }

        public List<String> getAnswerGiven() {
            return answerGiven;
        }

        public MultipleAnswerQuestion getAnswerQuestion() {
            return answerQuestion;
        }
    }
}
