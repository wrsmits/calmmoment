package wesley.calmmoment.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
//@PrimaryKeyJoinColumn(name = "question_id")
public class OpenQuestion extends Question {
    @Type(type = "org.hibernate.type.TextType")
    private String questionAnswer;

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
