package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.BooleanQuestion;
import wesley.calmmoment.model.QuestionType;
import wesley.calmmoment.services.BooleanQuestionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BooleanQuestionController {

    @Autowired
    private BooleanQuestionService booleanQuestionService;

    @GetMapping("/booleanQuestions")
    public List<BooleanQuestionSimple> getBooleanQuestions() {
        List<BooleanQuestion> booleanQuestions = booleanQuestionService.getBooleanQuestions();
        List<BooleanQuestionSimple> booleanQuestionSimple = new ArrayList<BooleanQuestionSimple>();
        for (BooleanQuestion bq : booleanQuestions) {
            booleanQuestionSimple.add(new BooleanQuestionSimple(bq.getQuestionId(), bq.getQuestionName(), bq.getQuestionWriter(), bq.getQuestionCaption(), bq.getQuestionType()));
        }

        return booleanQuestionSimple;
    }

    class BooleanQuestionSimple {
        private Long questionId;
        private String questionName;
        private AppUser questionWriter;
        private String questionCaption;
        private QuestionType questionType;

        public BooleanQuestionSimple(Long questionId, String questionName, AppUser questionWriter, String questionCaption, QuestionType questionType) {
            this.questionId = questionId;
            this.questionName = questionName;
            this.questionWriter = questionWriter;
            this.questionCaption = questionCaption;
            this.questionType = questionType;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public String getQuestionName() {
            return questionName;
        }

        public AppUser getQuestionWriter() {
            return questionWriter;
        }

        public String getQuestionCaption() {
            return questionCaption;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }
    }
}
