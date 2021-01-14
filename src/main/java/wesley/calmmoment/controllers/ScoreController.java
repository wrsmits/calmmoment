package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.Mood;
import wesley.calmmoment.model.Score;
import wesley.calmmoment.services.ScoreService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/scores")
    public List<ScoreSimple> getScores() {
        List<Score> scores = scoreService.getScores();
        List<ScoreSimple> scoreSimple = new ArrayList<ScoreSimple>();
        for (Score s : scores) {
            scoreSimple.add(new ScoreSimple(s.getScoreId(), s.getGivenScore(), s.getFeelScore(), s.getGivenBy(), s.isHelpful(), s.getTipDo(), s.getTipDont()));
        }

        return scoreSimple;
    }

    class ScoreSimple {
        private Long scoreId;
        private int scoreGiven;
        private Mood feelScore;
        private AppUser givenBy;
        private boolean helpful;
        private String tipDo;
        private String tipDont;

        public ScoreSimple(Long scoreId, int scoreGiven, Mood feelScore, AppUser givenBy, boolean helpful, String tipDo, String tipDont) {
            this.scoreId = scoreId;
            this.scoreGiven = scoreGiven;
            this.feelScore = feelScore;
            this.givenBy = givenBy;
            this.helpful = helpful;
            this.tipDo = tipDo;
            this.tipDont = tipDont;
        }

        public Long getScoreId() {
            return scoreId;
        }

        public int getScoreGiven() {
            return scoreGiven;
        }

        public Mood getFeelScore() {
            return feelScore;
        }

        public AppUser getGivenBy() {
            return givenBy;
        }

        public boolean isHelpful() {
            return helpful;
        }

        public String getTipDo() {
            return tipDo;
        }

        public String getTipDont() {
            return tipDont;
        }
    }
}
