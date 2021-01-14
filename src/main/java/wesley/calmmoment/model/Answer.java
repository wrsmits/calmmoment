package wesley.calmmoment.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;
    @Type(type = "org.hibernate.type.TextType")
    private String answerName;
    @OneToOne
    private AppUser answerWriter;
//    @ManyToOne
//    private Question answerQuestion;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public AppUser getAnswerWriter() {
        return answerWriter;
    }

    public void setAnswerWriter(AppUser answerWriter) {
        this.answerWriter = answerWriter;
    }

//    public Question getAnswerQuestion() {
//        return answerQuestion;
//    }

//    public void setAnswerQuestion(Question answerQuestion) {
//        this.answerQuestion = answerQuestion;
//    }
}
