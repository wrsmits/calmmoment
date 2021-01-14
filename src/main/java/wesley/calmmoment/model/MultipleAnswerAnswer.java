package wesley.calmmoment.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@PrimaryKeyJoinColumn(name = "answer_id")
public class MultipleAnswerAnswer extends Answer {
    @ElementCollection(targetClass = String.class)
    private List<String> answerGiven;
    @ManyToOne
    private MultipleAnswerQuestion answerQuestion;

    public List<String> getAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(List<String> answerGiven) {
        this.answerGiven = answerGiven;
    }

    public MultipleAnswerQuestion getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(MultipleAnswerQuestion answerQuestion) {
        this.answerQuestion = answerQuestion;
    }
}
