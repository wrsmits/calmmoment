package wesley.calmmoment.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    @Type(type = "org.hibernate.type.TextType")
    private String questionName;
    @OneToOne
    private AppUser questionWriter;
    @Type(type = "org.hibernate.type.TextType")
    private String questionCaption;
    private QuestionType questionType;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public AppUser getQuestionWriter() {
        return questionWriter;
    }

    public void setQuestionWriter(AppUser questionCreator) {
        this.questionWriter = questionCreator;
    }

    public String getQuestionCaption() {
        return questionCaption;
    }

    public void setQuestionCaption(String questionCaption) {
        this.questionCaption = questionCaption;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
