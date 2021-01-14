package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.MultipleChoiceQuestion;
import wesley.calmmoment.model.QuestionType;
import wesley.calmmoment.services.MultipleChoiceQuestionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MultipleChoiceQuestionController {

    @Autowired
    private MultipleChoiceQuestionService multipleChoiceQuestionService;

    @GetMapping("/multipleChoiceQuestions")
    public List<MultipleChoiceQuestionSimple> getMultipleChoiceQuestions() {
        List<MultipleChoiceQuestion> multipleChoiceQuestions = multipleChoiceQuestionService.getMultipleChoiceQuestions();
        List<MultipleChoiceQuestionSimple> multipleChoiceQuestionSimple = new ArrayList<MultipleChoiceQuestionSimple>();
        for (MultipleChoiceQuestion mcq : multipleChoiceQuestions) {
            multipleChoiceQuestionSimple.add(new MultipleChoiceQuestionSimple(mcq.getQuestionId(), mcq.getQuestionName(), mcq.getQuestionWriter(), mcq.getQuestionCaption(), mcq.getQuestionAnswer(), mcq.getQuestionType()));
        }

        return multipleChoiceQuestionSimple;
    }

    class MultipleChoiceQuestionSimple {
        private Long questionId;
        private String questionName;
        private AppUser questionWriter;
        private String questionCaption;
        private List<String> questionAnswer;
        private QuestionType questionType;

        public MultipleChoiceQuestionSimple(Long questionId, String questionName, AppUser questionWriter, String questionCaption, List<String> questionAnswer, QuestionType questionType) {
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
