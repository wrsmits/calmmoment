package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.*;
import wesley.calmmoment.services.TipService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipController {

    @Autowired
    private TipService tipService;

    @GetMapping("/tips")
    public List<TipSimple> getTips() {
        List<Tip> tipList = tipService.getTips();
        List<TipSimple> tipSimple = new ArrayList<TipSimple>();
        for (Tip t : tipList) {
            tipSimple.add(new TipSimple(t.getTipId(), t.getTipName(), t.getTipTitle(), t.getTipScore(), t.getTipWriter(), t.isTipPublished(), t.getTipDate(), /*t.getTipAnswer(),*/ t.getTipSituation()));
        }

        return tipSimple;
    }

    class TipSimple {
        private Long tipId;
        private String tipName;
        private String tipTitle;
        private Score tipScore;
        private AppUser tipWriter;
        private boolean tipPublished;
        private Date tipDate;
        //        private List<Answer> tipAnswer;
        private Situation tipSituation;

        public TipSimple(Long tipId, String tipName, String tipTitle, Score tipScore, AppUser tipWriter, boolean tipPublished, Date tipDate, /*List<Answer> tipAnswer,*/ Situation tipSituation) {
            this.tipId = tipId;
            this.tipName = tipName;
            this.tipTitle = tipTitle;
            this.tipScore = tipScore;
            this.tipWriter = tipWriter;
            this.tipPublished = tipPublished;
            this.tipDate = tipDate;
//            this.tipAnswer = tipAnswer;
            this.tipSituation = tipSituation;
        }

        public Long getTipId() {
            return tipId;
        }

        public String getTipName() {
            return tipName;
        }

        public String getTipTitle() {
            return tipTitle;
        }

        public Score getTipScore() {
            return tipScore;
        }

        public AppUser getTipWriter() {
            return tipWriter;
        }

        public boolean isTipPublished() {
            return tipPublished;
        }

        public Date getTipDate() {
            return tipDate;
        }

//        public List<Answer> getTipAnswer() {
//            return tipAnswer;
//        }

        public Situation getTipSituation() {
            return tipSituation;
        }
    }
}
