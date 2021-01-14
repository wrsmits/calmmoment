package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.OpenAnswer;
import wesley.calmmoment.model.OpenQuestion;
import wesley.calmmoment.services.OpenAnswerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OpenAnswerController {

    @Autowired
    private OpenAnswerService openAnswerService;

    @GetMapping("/openanswers")
    public List<OpenAnswerSimple> getOpenAnswers() {
        List<OpenAnswer> openAnswers = openAnswerService.getOpenAnswers();
        List<OpenAnswerSimple> openAnswerSimple = new ArrayList<OpenAnswerSimple>();
        for (OpenAnswer oa : openAnswers) {
            openAnswerSimple.add(new OpenAnswerSimple(oa.getAnswerId(), oa.getAnswerName(), oa.getAnswerWriter(), oa.getAnswerGiven(), oa.getAnswerQuestion()));
        }

        return openAnswerSimple;
    }

    class OpenAnswerSimple {
        private Long answerId;
        private String answerName;
        private AppUser answerWriter;
        private String answerGiven;
        private OpenQuestion answerQuestion;

        public OpenAnswerSimple(Long answerId, String answerName, AppUser answerWriter, String answerGiven, OpenQuestion answerQuestion) {
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

        public String getAnswerGiven() {
            return answerGiven;
        }

        public OpenQuestion getAnswerQuestion() {
            return answerQuestion;
        }
    }
}
