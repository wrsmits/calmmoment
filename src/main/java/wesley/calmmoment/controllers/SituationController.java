package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.Question;
import wesley.calmmoment.model.Situation;
import wesley.calmmoment.services.SituationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SituationController {

    @Autowired
    private SituationService situationService;

    @GetMapping("/situations")
    public List<SituationSimple> getSituation() {
        List<Situation> situations = situationService.getSituations();
        List<SituationSimple> situationSimple = new ArrayList<SituationSimple>();
        for (Situation s : situations) {
            situationSimple.add(new SituationSimple(s.getSituationId(), s.getSituationName(), s.getSituationTitle(), s.getSituationWriter(), s.getSituationImage(), s.getSituationQuestion()));
        }

        return situationSimple;
    }

    @GetMapping("/situations-no-questions")
    public List<SimpleSituation> getSituationWOQ() {
        List<Situation> situations = situationService.getSituations();
        List<SimpleSituation> simpleSituation = new ArrayList<SimpleSituation>();
        for (Situation s : situations) {
            simpleSituation.add(new SimpleSituation(s.getSituationId(), s.getSituationName(), s.getSituationTitle(), s.getSituationImage()));
        }

        return simpleSituation;
    }

    @GetMapping("/situations/{situationId}")
    public Situation getSituation(@PathVariable Long situationId) {
        return situationService.getSituation(situationId);
    }

    class SituationSimple {
        private Long situationId;
        private String situationName;
        private String situationTitle;
        private AppUser situationWriter;
        private String situationImage;
        private List<Question> situationQuestion;

        public SituationSimple(Long situationId, String situationName, String situationTitle, AppUser situationWriter, String situationImage, List<Question> situationQuestion) {
            this.situationId = situationId;
            this.situationName = situationName;
            this.situationTitle = situationTitle;
            this.situationWriter = situationWriter;
            this.situationImage = situationImage;
            this.situationQuestion = situationQuestion;
        }

        public Long getSituationId() {
            return situationId;
        }

        public String getSituationName() {
            return situationName;
        }

        public String getSituationTitle() {
            return situationTitle;
        }

        public AppUser getSituationWriter() {
            return situationWriter;
        }

        public String getSituationImage() {
            return situationImage;
        }

        public List<Question> getSituationQuestion() {
            return situationQuestion;
        }
    }

    class SimpleSituation {
        private Long situationId;
        private String situationName;
        private String situationTitle;
        private String situationImage;

        public SimpleSituation(Long situationId, String situationName, String situationTitle, String situationImage) {
            this.situationId = situationId;
            this.situationName = situationName;
            this.situationTitle = situationTitle;
            this.situationImage = situationImage;
        }

        public Long getSituationId() {
            return situationId;
        }

        public String getSituationName() {
            return situationName;
        }

        public String getSituationTitle() {
            return situationTitle;
        }

        public String getSituationImage() {
            return situationImage;
        }
    }
}
