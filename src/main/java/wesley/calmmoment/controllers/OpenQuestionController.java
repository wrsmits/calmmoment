package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.OpenQuestion;
import wesley.calmmoment.model.QuestionType;
import wesley.calmmoment.services.OpenQuestionsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OpenQuestionController {

    @Autowired
    private OpenQuestionsService openQuestionsService;

    @GetMapping("/openquestions")
    public List<OpenQuestionSimple> getOpenQuestions() {
        List<OpenQuestion> openQuestions = openQuestionsService.getOpenQuestions();
        List<OpenQuestionSimple> openQuestionSimple = new ArrayList<OpenQuestionSimple>();
        for (OpenQuestion oq : openQuestions) {
            openQuestionSimple.add(new OpenQuestionSimple(oq.getQuestionId(), oq.getQuestionName(), oq.getQuestionWriter(), oq.getQuestionCaption(), oq.getQuestionAnswer(), oq.getQuestionType()));
        }

        return openQuestionSimple;
    }

    class OpenQuestionSimple {
        private Long questionId;
        private String questionName;
        private AppUser questionWriter;
        private String questionCaption;
        private String questionAnswer;
        private QuestionType questionType;

        public OpenQuestionSimple(Long questionId, String questionName, AppUser questionWriter, String questionCaption, String questionAnswer, QuestionType questionType) {
            this.questionId = questionId;
            this.questionName = questionName;
            this.questionWriter = questionWriter;
            this.questionCaption = questionCaption;
            this.questionAnswer = questionAnswer;
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

        public String getQuestionAnswer() {
            return questionAnswer;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }
    }
}
