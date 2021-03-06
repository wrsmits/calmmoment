package wesley.calmmoment.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
//@PrimaryKeyJoinColumn(name = "question_id")
public class MultipleAnswerQuestion extends Question {
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> questionAnswer;

    public List<String> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(List<String> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
