package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.MultipleAnswerQuestion;
import wesley.calmmoment.model.QuestionType;
import wesley.calmmoment.services.MultipleAnswerQuestionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultipleAnswerQuestionController {

    @Autowired
    private MultipleAnswerQuestionService multipleAnswerQuestionService;

    @GetMapping("/multipleAnswerQuestions")
    public List<MultipleAnswerQuestionSimple> getMultipleAnswerQuestions() {
        List<MultipleAnswerQuestion> multipleAnswerQuestions = multipleAnswerQuestionService.getMultipleAnswerQuestions();
        List<MultipleAnswerQuestionSimple> multipleAnswerQuestionSimple = new ArrayList<MultipleAnswerQuestionSimple>();
        for (MultipleAnswerQuestion maq : multipleAnswerQuestions) {
            multipleAnswerQuestionSimple.add(new MultipleAnswerQuestionSimple(maq.getQuestionId(), maq.getQuestionName(), maq.getQuestionWriter(), maq.getQuestionCaption(), maq.getQuestionAnswer(), maq.getQuestionType()));
        }

        return multipleAnswerQuestionSimple;
    }

    class MultipleAnswerQuestionSimple {
        private Long questionId;
        private String questionName;
        private AppUser questionWriter;
        private String questionCaption;
        private List<String> questionAnswer;
        private QuestionType questionType;

        public MultipleAnswerQuestionSimple(Long questionId, String questionName, AppUser questionWriter, String questionCaption, List<String> questionAnswer, QuestionType questionType) {
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

        public List<String> getQuestionAnswer() {
            return questionAnswer;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }
    }
}
