package wesley.calmmoment.model;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumn(name = "answer_id")
public class BooleanAnswer extends Answer {
    private boolean answerGiven;
    @ManyToOne
    private BooleanQuestion answerQuestion;

    public boolean isAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(boolean answerGiven) {
        this.answerGiven = answerGiven;
    }

    public BooleanQuestion getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(BooleanQuestion answerQuestion) {
        this.answerQuestion = answerQuestion;
    }
}
