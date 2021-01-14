package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.*;
import wesley.calmmoment.services.BooleanAnswerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BooleanAnswerController {

    @Autowired
    private BooleanAnswerService booleanAnswerService;

    @GetMapping("/booleanAnswers")
    public List<BooleanAnswerSimple> getBooleanAnswers() {
        List<BooleanAnswer> booleanAnswers = booleanAnswerService.getBooleanAnswers();
        List<BooleanAnswerSimple> booleanAnswerSimple = new ArrayList<BooleanAnswerSimple>();
        for (BooleanAnswer ba : booleanAnswers) {
            booleanAnswerSimple.add(new BooleanAnswerSimple(ba.getAnswerId(), ba.getAnswerName(), ba.getAnswerWriter(), ba.isAnswerGiven(), ba.getAnswerQuestion()));
        }

        return booleanAnswerSimple;
    }

    class BooleanAnswerSimple {
        private Long answerId;
        private String answerName;
        private AppUser answerWriter;
        private boolean answerGiven;
        private BooleanQuestion answerQuestion;

        public BooleanAnswerSimple(Long answerId, String answerName, AppUser answerWriter, boolean answerGiven, BooleanQuestion answerQuestion) {
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

        public boolean isAnswerGiven() {
            return answerGiven;
        }

        public BooleanQuestion getAnswerQuestion() {
            return answerQuestion;
        }
    }
}
