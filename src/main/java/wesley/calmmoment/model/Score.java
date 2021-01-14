package wesley.calmmoment.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreId;
    private int givenScore;
    @Enumerated(EnumType.STRING)
    private Mood feelScore;
    @OneToOne
    private AppUser givenBy;
    private boolean helpful;
    @Type(type = "org.hibernate.type.TextType")
    private String tipDo;
    @Type(type = "org.hibernate.type.TextType")
    private String tipDont;

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public int getGivenScore() {
        return givenScore;
    }

    public void setGivenScore(int givenScore) {
        this.givenScore = givenScore;
    }

    public Mood getFeelScore() {
        return feelScore;
    }

    public void setFeelScore(Mood feelScore) {
        this.feelScore = feelScore;
    }

    public AppUser getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(AppUser givenBy) {
        this.givenBy = givenBy;
    }

    public boolean isHelpful() {
        return helpful;
    }

    public void setHelpful(boolean helpful) {
        this.helpful = helpful;
    }

    public String getTipDo() {
        return tipDo;
    }

    public void setTipDo(String tipDo) {
        this.tipDo = tipDo;
    }

    public String getTipDont() {
        return tipDont;
    }

    public void setTipDont(String tipDont) {
        this.tipDont = tipDont;
    }
}
