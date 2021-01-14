package wesley.calmmoment.model;

import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tipId;
    @Type(type = "org.hibernate.type.TextType")
    private String tipName;
    @Type(type = "org.hibernate.type.TextType")
    private String tipTitle;
    @OneToOne
    private Score tipScore;
    @OneToOne
    private AppUser tipWriter;
    private boolean tipPublished;
    private Date tipDate;
    //    @ManyToMany
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Answer> tipAnswer;
    @OneToOne
    private Situation tipSituation;

    public Long getTipId() {
        return tipId;
    }

    public void setTipId(Long tipId) {
        this.tipId = tipId;
    }

    public String getTipName() {
        return tipName;
    }

    public void setTipName(String tipName) {
        this.tipName = tipName;
    }

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public Score getTipScore() {
        return tipScore;
    }

    public void setTipScore(Score tipScore) {
        this.tipScore = tipScore;
    }

    public AppUser getTipWriter() {
        return tipWriter;
    }

    public void setTipWriter(AppUser tipWriter) {
        this.tipWriter = tipWriter;
    }

    public boolean isTipPublished() {
        return tipPublished;
    }

    public void setTipPublished(boolean tipPublished) {
        this.tipPublished = tipPublished;
    }

    public Date getTipDate() {
        return tipDate;
    }

    public void setTipDate(Date tipDate) {
        this.tipDate = tipDate;
    }

//    public List<Answer> getTipAnswer() {
//        return tipAnswer;
//    }
//
//    public void setTipAnswer(List<Answer> tipAnswer) {
//        this.tipAnswer = tipAnswer;
//    }

    public Situation getTipSituation() {
        return tipSituation;
    }

    public void setTipSituation(Situation tipSituation) {
        this.tipSituation = tipSituation;
    }
}
