package wesley.calmmoment.model;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumn(name = "answer_id")
public class MultipleChoiceAnswer extends Answer {
    private String answerGiven;
    @ManyToOne
    private MultipleChoiceQuestion answerQuestion;

    public String getAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(String answerGiven) {
        this.answerGiven = answerGiven;
    }

    public MultipleChoiceQuestion getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(MultipleChoiceQuestion answerQuestion) {
        this.answerQuestion = answerQuestion;
    }
}
