package wesley.calmmoment.model;

import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long situationId;
    @Type(type = "org.hibernate.type.TextType")
    private String situationName;
    @Type(type = "org.hibernate.type.TextType")
    private String situationTitle;
    @OneToOne
    private AppUser situationWriter;
    @Type(type = "org.hibernate.type.TextType")
    private String situationImage;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> situationQuestion;

    public Long getSituationId() {
        return situationId;
    }

    public void setSituationId(Long situationId) {
        this.situationId = situationId;
    }

    public String getSituationName() {
        return situationName;
    }

    public void setSituationName(String situationName) {
        this.situationName = situationName;
    }

    public String getSituationTitle() {
        return situationTitle;
    }

    public void setSituationTitle(String situationTitle) {
        this.situationTitle = situationTitle;
    }

    public AppUser getSituationWriter() {
        return situationWriter;
    }

    public void setSituationWriter(AppUser situationWriter) {
        this.situationWriter = situationWriter;
    }

    public String getSituationImage() {
        return situationImage;
    }

    public void setSituationImage(String situationImage) {
        this.situationImage = situationImage;
    }

    public List<Question> getSituationQuestion() {
        return situationQuestion;
    }

    public void setSituationQuestion(List<Question> situationQuestion) {
        this.situationQuestion = situationQuestion;
    }
}
