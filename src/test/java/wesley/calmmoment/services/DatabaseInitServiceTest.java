package wesley.calmmoment.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import wesley.calmmoment.model.*;
import wesley.calmmoment.repositories.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseInitServiceTest {
    @Mock
    private BooleanAnswerRepository booleanAnswerRepository;
    @Mock
    private List<BooleanAnswer> booleanAnswers;

    @Mock
    private BooleanQuestionRepository booleanQuestionRepository;
    @Mock
    private List<BooleanQuestion> booleanQuestions;

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private List<Category> categories;

    @Mock
    private MultipleAnswerAnswerRepository multipleAnswerAnswerRepository;
    @Mock
    private List<MultipleAnswerAnswer> maAnswers;

    @Mock
    private MultipleAnswerQuestionRepository multipleAnswerQuestionRepository;
    @Mock
    private List<MultipleAnswerQuestion> maQuestions;

    @Mock
    private MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;
    @Mock
    private List<MultipleChoiceAnswer> mcAnswers;

    @Mock
    private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    @Mock
    private List<MultipleChoiceQuestion> mcQuestions;

    @Mock
    private OpenAnswerRepository openAnswerRepository;
    @Mock
    private List<OpenAnswer> openAnswers;

    @Mock
    private OpenQuestionRepository openQuestionRepository;
    @Mock
    private List<OpenQuestion> openQuestions;

    @Mock
    private ScoreRepository scoreRepository;
    @Mock
    private List<Score> scores;

    @Mock
    private SituationRepository situationRepository;
    @Mock
    private List<Situation> situations;

    @Mock
    private TipRepository tipRepository;
    @Mock
    private List<Tip> tips;

    @Mock
    private UserRepository userRepository;
    @Mock
    private List<AppUser> appUsers;

    @Test
    public void createUser() {
        AppUser sergio = new AppUser();
        sergio.setUserId((long) 123);
        sergio.setUserName("SergioDeGekste");
        sergio.setUserFirstName("Sergio");
        sergio.setUserLastName("De Gekste");
        sergio.setUserEmail("sergio@pina.nl");
        sergio.setUserImage("");
        sergio.setUserPassword("Sergio<3Pina");
        appUsers.add(sergio);
        AppUser pina = new AppUser();
        pina.setUserId((long) 456);
        pina.setUserName("PinaDeSnelste");
        pina.setUserFirstName("Pina");
        pina.setUserLastName("De Snelste");
        pina.setUserEmail("pina@sergio.nl");
        pina.setUserImage("");
        pina.setUserPassword("Pina<3Sergio");
        appUsers.add(pina);

        userRepository.saveAll(appUsers);
    }

    @Test
    public void createBoolQuestion() {
        BooleanQuestion booleanQuestion = new BooleanQuestion();
        booleanQuestion.setQuestionName("Zijn Sergio en Pina leuke konijnen?");
        booleanQuestion.setQuestionCaption("Hint: Ja, dat zijn ze zeker!");
        booleanQuestion.setQuestionWriter(appUsers.get(0));
        booleanQuestion.setQuestionType(QuestionType.B);
        booleanQuestions.add(booleanQuestion);

        booleanQuestionRepository.saveAll(booleanQuestions);
    }

    @Test
    public void createBoolAnswer() {
        BooleanAnswer booleanAnswer = new BooleanAnswer();
        booleanAnswer.setAnswerName("Ja");
        booleanAnswer.setAnswerWriter(appUsers.get(0));
        booleanAnswer.setAnswerGiven(true);
        booleanAnswer.setAnswerQuestion(booleanQuestions.get(0));
        booleanAnswers.add(booleanAnswer);

        booleanAnswerRepository.saveAll(booleanAnswers);
    }

    @Test
    public void createMultipleChoiceQuestion() {
        MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
        multipleChoiceQuestion.setQuestionName("Zijn Sergio en Pina leuke konijnen?");
        multipleChoiceQuestion.setQuestionCaption("Hint: Sergio is een leuk konijn. Net als Pina.");
        multipleChoiceQuestion.setQuestionWriter(appUsers.get(0));
        multipleChoiceQuestion.setQuestionType(QuestionType.MC);
        multipleChoiceQuestion.setQuestionAnswer(new ArrayList<>(Arrays.asList("JA", "JA!", "JA!!", "JA!!!")));
        mcQuestions.add(multipleChoiceQuestion);

        multipleChoiceQuestionRepository.saveAll(mcQuestions);
    }

    @Test
    public void createMultipleChoiceAnswer() {
        MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
        multipleChoiceAnswer.setAnswerQuestion(mcQuestions.get(0));
        multipleChoiceAnswer.setAnswerGiven("JA!!!");
        multipleChoiceAnswer.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(multipleChoiceAnswer);

        multipleChoiceAnswerRepository.saveAll(mcAnswers);
    }

    @Test
    public void createOpenQuestion() {
        OpenQuestion q1 = new OpenQuestion();
        q1.setQuestionName("Zijn Sergio en Pina leuke konijnen?");
        q1.setQuestionCaption("Je moet verplicht iets positiefs over Sergio en Pina zeggen.");
        q1.setQuestionWriter(appUsers.get(0));
        q1.setQuestionType(QuestionType.O);
        openQuestions.add(q1);

        openQuestionRepository.saveAll(openQuestions);
    }

    @Test
    public void createOpenAnswer() {
        OpenAnswer openAnswer = new OpenAnswer();
        openAnswer.setAnswerQuestion(openQuestions.get(0));
        openAnswer.setAnswerName("Ja");
        openAnswer.setAnswerGiven("Ja, Sergio en Pina zijn de leukste konijnen ter wereld!");
        openAnswer.setAnswerWriter(appUsers.get(0));
        openAnswers.add(openAnswer);

        openAnswerRepository.saveAll(openAnswers);
    }

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setCategoryName("Sergio en Pina");
        category.setCategoryTitle("Sergio en Pina zijn de leukste konijnen");
        category.setCategoryWriter(appUsers.get(0));
        category.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(0))));
        category.setCategoryImage("");
        categories.add(category);

        categoryRepository.saveAll(categories);
    }

    @Test
    public void createSituation() {
        Situation situation = new Situation();
        situation.setSituationName("Sprongen maken");
        situation.setSituationTitle("Sergio en Pina maken mooie sprongen");
        situation.setSituationWriter(appUsers.get(0));
        situation.setSituationImage("");
        situation.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), maQuestions.get(0), openQuestions.get(0), booleanQuestions.get(0))));
        situations.add(situation);

        situationRepository.saveAll(situations);
    }

    @Test
    public void createMultipleAnswerQuestion() {
        MultipleAnswerQuestion multipleAnswerQuestion = new MultipleAnswerQuestion();
        multipleAnswerQuestion.setQuestionName("Wil je Sergio en Pina aaien?");
        multipleAnswerQuestion.setQuestionCaption("Of je de leukste, zachtste konijnen ooit wil aaien.");
        multipleAnswerQuestion.setQuestionAnswer(new ArrayList<>(Arrays.asList("Ja", "Jazeker", "Zeker weten", "Uhhh... JA!")));
        multipleAnswerQuestion.setQuestionWriter(appUsers.get(0));
        multipleAnswerQuestion.setQuestionType(QuestionType.MA);
        maQuestions.add(multipleAnswerQuestion);

        multipleAnswerQuestionRepository.saveAll(maQuestions);
    }

    @Test
    public void createMultipleAnswerAnswer() {
        MultipleAnswerAnswer multipleAnswerAnswer = new MultipleAnswerAnswer();
        multipleAnswerAnswer.setAnswerQuestion(maQuestions.get(0));
        multipleAnswerAnswer.setAnswerGiven(new ArrayList<>(Arrays.asList("Ja", "Jazeker", "Zeker weten", "Uhhh... JA!")));
        multipleAnswerAnswer.setAnswerWriter(appUsers.get(0));
        maAnswers.add(multipleAnswerAnswer);

        multipleAnswerAnswerRepository.saveAll(maAnswers);
    }

    @Test
    public void createScore() {
        Score score = new Score();
        score.setGivenBy(appUsers.get(0));
        score.setFeelScore(Mood.HAPPY);
        score.setGivenScore(10);
        score.setHelpful(true);
        score.setTipDo("Sergio en Pina een wortel geven.");
        score.setTipDont("Sergio en Pina geen wortel geven.");
        scores.add(score);

        scoreRepository.saveAll(scores);
    }

    @Test
    public void createTip() {
        Tip tip = new Tip();
        tip.setTipName("Houd Sergio en Pina in de gaten");
        tip.setTipTitle("Het zijn de leukste konijnen ooit, dus je moet alles zien!");
        tip.setTipDate(new Date());
        tip.setTipPublished(true);
        tip.setTipScore(scores.get(0));
        tip.setTipWriter(appUsers.get(0));
        tip.setTipSituation(situations.get(0));
        tips.add(tip);

        tipRepository.saveAll(tips);
    }

    @Test
    public void createAll() {
        createUser();
        System.out.println("Users created");
        createBoolQuestion();
        System.out.println("BoolQuestions created");
        createBoolAnswer();
        System.out.println("BoolAnswers created");
        createMultipleChoiceQuestion();
        System.out.println("MultipleChoiceQuestions created");
        createMultipleChoiceAnswer();
        System.out.println("MultipleChoiceAnswers created");
        createOpenQuestion();
        System.out.println("OpenQuestions created");
        createOpenAnswer();
        System.out.println("OpenAnswers created");
        createMultipleAnswerQuestion();
        System.out.println("MultipleAnswerQuestions created");
        createMultipleAnswerAnswer();
        System.out.println("MultipleAnswerAnswers created");
        createSituation();
        System.out.println("Situations created");
        createCategory();
        System.out.println("Categories created");
        createScore();
        System.out.println("Scores created");
        createTip();
        System.out.println("Tips created");
    }
}
