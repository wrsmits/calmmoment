package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.MultipleChoiceAnswer;
import wesley.calmmoment.model.MultipleChoiceQuestion;
import wesley.calmmoment.services.MultipleChoiceAnswerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultipleChoiceAnswerController {

    @Autowired
    private MultipleChoiceAnswerService multipleChoiceAnswerService;

    @GetMapping("/multipleChoiceAnswers")
    public List<MultipleChoiceAnswerSimple> getMultipleChoiceAnswers() {
        List<MultipleChoiceAnswer> multipleChoiceAnswers = multipleChoiceAnswerService.getMultipleChoiceAnswers();
        List<MultipleChoiceAnswerSimple> multipleChoiceAnswerSimple = new ArrayList<MultipleChoiceAnswerSimple>();
        for (MultipleChoiceAnswer mca : multipleChoiceAnswers) {
            multipleChoiceAnswerSimple.add(new MultipleChoiceAnswerSimple(mca.getAnswerId(), mca.getAnswerName(), mca.getAnswerWriter(), mca.getAnswerGiven(), mca.getAnswerQuestion()));
        }

        return multipleChoiceAnswerSimple;
    }

    class MultipleChoiceAnswerSimple {
        private Long answerId;
        private String answerName;
        private AppUser answerWriter;
        private String answerGiven;
        private MultipleChoiceQuestion answerQuestion;

        public MultipleChoiceAnswerSimple(Long answerId, String answerName, AppUser answerWriter, String answerGiven, MultipleChoiceQuestion answerQuestion) {
            this.answerId = answerId;
            this.answerName = answerName;
            this.answerWriter = answerWriter;
            this.answerGiven = answerGiven;
            this.answerQuestion = answerQuestion;
        }

        private Long getAnswerId() {
            return answerId;
        }

        private String getAnswerName() {
            return answerName;
        }

        private AppUser getAnswerWriter() {
            return answerWriter;
        }

        private String getAnswerGiven() {
            return answerGiven;
        }

        private MultipleChoiceQuestion getAnswerQuestion() {
            return answerQuestion;
        }
    }
}
