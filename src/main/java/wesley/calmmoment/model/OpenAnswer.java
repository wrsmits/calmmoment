package wesley.calmmoment.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumn(name = "answer_id")
public class OpenAnswer extends Answer {
    @Type(type = "org.hibernate.type.TextType")
    private String answerGiven;
    @ManyToOne
    private OpenQuestion answerQuestion;

    public String getAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(String givenAnswer) {
        this.answerGiven = givenAnswer;
    }

    public OpenQuestion getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(OpenQuestion answerQuestion) {
        this.answerQuestion = answerQuestion;
    }
}
