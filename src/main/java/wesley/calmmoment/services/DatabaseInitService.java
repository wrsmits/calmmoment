package wesley.calmmoment.services;

import wesley.calmmoment.model.*;
import wesley.calmmoment.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//Met deze service wordt de database aangemaakt. Om de database aan te maken wordt er verbinding gemaakt met een PostgreSQL-database.
//Deze service wordt gehost in een Tomcat-server waardoor er online verbinding gemaakt kan worden met de PostgreSQL-database.
//In de methodes die in deze service staan worden alle entiteiten gevuld.
@Service
public class DatabaseInitService {
    //--> Aangemaakt 01-12 || Alle BooleanAnswers worden hierin gestopt. De BooleanAnswers zijn afhankelijk van de BooleanQuestions.
    @Autowired
    private BooleanAnswerRepository booleanAnswerRepository;
    private List<BooleanAnswer> booleanAnswers;
    //--> Aangemaakt 01-12 || Alle BooleanQuestions worden hierin gestopt. De BooleanAnswers zijn afhankelijk van de BooleanQuestions.
    @Autowired
    private BooleanQuestionRepository booleanQuestionRepository;
    private List<BooleanQuestion> booleanQuestions;
    //--> Aangemaakt 06-12 || alle Categories worden hierin gestopt. De Situations zijn afhankelijk van de Categories.
    @Autowired
    private CategoryRepository categoryRepository;
    private List<Category> categories;
    //--> Aangemaakt 06-12 || Alle MultipleAnswerAnswers worden hierin gestopt. De MultipleAnswerAnswers zijn afhankelijk van de MultipleAnswerQuestions.
    @Autowired
    private MultipleAnswerAnswerRepository multipleAnswerAnswerRepository;
    private List<MultipleAnswerAnswer> maAnswers;
    //--> Aangemaakt 06-12 || Alle MultipleAnswerQuestions worden hierin gestopt. De MultipleAnswerAnswers zijn afhankelijk van de MultipleAnswerQuestions.
    @Autowired
    private MultipleAnswerQuestionRepository multipleAnswerQuestionRepository;
    private List<MultipleAnswerQuestion> maQuestions;
    //--> Aangemaakt 01-12 || Alle MultipleChoiceAnswers worden hierin gestopt. De MultipleChoiceAnswers zijn afhankelijk van de MultipleChoiceQuestions.
    @Autowired
    private MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;
    private List<MultipleChoiceAnswer> mcAnswers;
    //--> Aangemaakt 06-12 || Alle MultipleChoiceQuestions worden hierin gestopt. De MultipleChoiceAnswers zijn afhankelijk van de MultipleChoiceQuestions.
    @Autowired
    private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private List<MultipleChoiceQuestion> mcQuestions;
    //--> Aangemaakt 06-12 || Alle OpenAnswers worden hierin gestopt. De OpenAnswers zijn afhankelijk van de OpenQuestions.
    @Autowired
    private OpenAnswerRepository openAnswerRepository;
    private List<OpenAnswer> openAnswers;
    //--> Aangemaakt 06-12 || Alle OpenQuestions worden hierin gestopt. De OpenAnswers zijn afhankelijk van de OpenQuestions.
    @Autowired
    private OpenQuestionRepository openQuestionRepository;
    private List<OpenQuestion> openQuestions;
    //--> Aangemaakt 06-12 || Alle Scores worden hierin gestopt. De Scores zijn afhankelijk van de Users.
    @Autowired
    private ScoreRepository scoreRepository;
    private List<Score> scores;
    //--> Aangemaakt 06-12 || alle Situations worden hierin gestopt. De Situations zijn afhankelijk van de Categories.
    @Autowired
    private SituationRepository situationRepository;
    private List<Situation> situations;
    //--> Aangemaakt 06-12 || All Tips worden hierin gestopt. De Tips zijn afhankelijk van de Situations, Scores en Answers.
    @Autowired
    private TipRepository tipRepository;
    private List<Tip> tips;
    //--> Aangemaakt 01-12 || Alle Users worden hierin gestopt.
    @Autowired
    private UserRepository userRepository;
    private List<AppUser> appUsers;

    public void createUser() {
        appUsers = new ArrayList<>();
        AppUser appUser1 = new AppUser();
        appUser1.setUserFirstName("Wesley");
        appUser1.setUserLastName("Smits");
        appUser1.setUserFullName(appUser1.getUserFirstName() + " " + appUser1.getUserLastName());
        appUser1.setUserEmail("w.r.smits@hotmail.com");
        appUser1.setUserName("wrsmits90");
        appUser1.setUserPassword("Welkom01!");
        appUser1.setUserImage("");
        appUsers.add(appUser1);

        userRepository.saveAll(appUsers);
    }

    public void createBoolQuestion() {
        booleanQuestions = new ArrayList<>();
        BooleanQuestion q1 = new BooleanQuestion();
        q1.setQuestionName("Is the location used as expected?");
        q1.setQuestionCaption("When a church has always been used as a museum answer 'Yes', otherwise answer 'No'.");
        q1.setQuestionWriter(appUsers.get(0));
        q1.setQuestionType(QuestionType.B);
        booleanQuestions.add(q1);
        BooleanQuestion q2 = new BooleanQuestion();
        q2.setQuestionName("Do you want to publish this report for others to see?");
        q2.setQuestionCaption("When you select yes other users will see the review you have created. It will not be visible for others who created the review.");
        q2.setQuestionWriter(appUsers.get(0));
        q2.setQuestionType(QuestionType.B);
        booleanQuestions.add(q2);
        BooleanQuestion q3 = new BooleanQuestion();
        q3.setQuestionName("Yes/No");
        q3.setQuestionCaption("Select 'Yes' or 'No'");
        q3.setQuestionWriter(appUsers.get(0));
        q3.setQuestionType(QuestionType.B);
        booleanQuestions.add(q3);

        booleanQuestionRepository.saveAll(booleanQuestions);
    }

    public void createBoolAnswer() {
        booleanAnswers = new ArrayList<>();
        BooleanAnswer a1 = new BooleanAnswer();
        a1.setAnswerName("Yes");
        a1.setAnswerWriter(appUsers.get(0));
        a1.setAnswerGiven(true);
        a1.setAnswerQuestion(booleanQuestions.get(0));
        booleanAnswers.add(a1);
        BooleanAnswer a2 = new BooleanAnswer();
        a2.setAnswerName("No");
        a2.setAnswerWriter(appUsers.get(0));
        a2.setAnswerGiven(false);
        a2.setAnswerQuestion(booleanQuestions.get(0));
        booleanAnswers.add(a2);
        BooleanAnswer a3 = new BooleanAnswer();
        a3.setAnswerName("Yes");
        a3.setAnswerWriter(appUsers.get(0));
        a3.setAnswerGiven(true);
        a3.setAnswerQuestion(booleanQuestions.get(1));
        booleanAnswers.add(a3);
        BooleanAnswer a4 = new BooleanAnswer();
        a4.setAnswerName("No");
        a4.setAnswerWriter(appUsers.get(0));
        a4.setAnswerGiven(false);
        a4.setAnswerQuestion(booleanQuestions.get(1));
        booleanAnswers.add(a4);
        BooleanAnswer a5 = new BooleanAnswer();
        a5.setAnswerName("Yes");
        a5.setAnswerWriter(appUsers.get(0));
        a5.setAnswerGiven(true);
        a5.setAnswerQuestion(booleanQuestions.get(2));
        booleanAnswers.add(a5);
        BooleanAnswer a6 = new BooleanAnswer();
        a6.setAnswerName("No");
        a6.setAnswerWriter(appUsers.get(0));
        a6.setAnswerGiven(false);
        a6.setAnswerQuestion(booleanQuestions.get(2));
        booleanAnswers.add(a6);

        booleanAnswerRepository.saveAll(booleanAnswers);
    }

    public void createMultipleChoiceQuestion() {
        mcQuestions = new ArrayList<>();
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion();
        q1.setQuestionName("Do you know the people?");
        q1.setQuestionCaption("For example; if you are in a museum and you know everyone with whom you are there, you know the most important people.");
        q1.setQuestionWriter(appUsers.get(0));
        q1.setQuestionType(QuestionType.MC);
        q1.setQuestionAnswer(new ArrayList<>(Arrays.asList("No, no one", "No, only one person or a few people", "Yes, the most important people", "Yes, I know (almost) everyone.")));
        mcQuestions.add(q1);
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion();
        q2.setQuestionName("How many people will be there?");
        q2.setQuestionCaption("Do not count yourself.");
        q2.setQuestionWriter(appUsers.get(0));
        q2.setQuestionType(QuestionType.MC);
        q2.setQuestionAnswer(new ArrayList<>(Arrays.asList("Only me", "One person", "Only one person at a time", "Two to five people", "Five to ten people", "Ten to twenty five people", "Twenty five to one hundred people", "More than one hundred people")));
        mcQuestions.add(q2);
        MultipleChoiceQuestion q3 = new MultipleChoiceQuestion();
        q3.setQuestionName("Will there be someone with you?");
        q3.setQuestionCaption("Someone who helps you relax, can do so consciously or unconsciously.");
        q3.setQuestionWriter(appUsers.get(0));
        q3.setQuestionType(QuestionType.MC);
        q3.setQuestionAnswer(new ArrayList<>(Arrays.asList("Yes, someone that helps me relax", "Yes", "No")));
        mcQuestions.add(q3);
        MultipleChoiceQuestion q4 = new MultipleChoiceQuestion();
        q4.setQuestionName("What division of roles describes the situation best?");
        q4.setQuestionCaption("Interview: order, question, discussion, meeting\n" + "Group: party, introduction week\n" + "Audience: follow lesson, visit concert, cinema\n" + "In front of an audience: perform, teach, speech");
        q4.setQuestionWriter(appUsers.get(0));
        q4.setQuestionType(QuestionType.MC);
        q4.setQuestionAnswer(new ArrayList<>(Arrays.asList("Interview", "Group", "Audience", "In front of an audience")));
        mcQuestions.add(q4);
        MultipleChoiceQuestion q5 = new MultipleChoiceQuestion();
        q5.setQuestionName("Do you know the location?");
        q5.setQuestionCaption("Yes: you know where to go, where you can find what you want, where you have to sit\n" + "and wait\n" + "Kind of: a little, or you know how to find out where to go\n" + "No: you don’t know where to go, you don’t know whether locations are clearly marked");
        q5.setQuestionWriter(appUsers.get(0));
        q5.setQuestionType(QuestionType.MC);
        q5.setQuestionAnswer(new ArrayList<>(Arrays.asList("Yes", "Kind of", "No")));
        mcQuestions.add(q5);
        MultipleChoiceQuestion q6 = new MultipleChoiceQuestion();
        q6.setQuestionName("Do you know the way to behave that is associated with this location?");
        q6.setQuestionCaption("Do you know whether to be quiet, whether you are allowed to walk away at any moment, when you’re allowed to go to the toilet, who you are allowed/must talk to?");
        q6.setQuestionWriter(appUsers.get(0));
        q6.setQuestionType(QuestionType.MC);
        q6.setQuestionAnswer(new ArrayList<>(Arrays.asList("Yes", "No, but it will be explained", "No, but someone will probably explain it", "No")));
        mcQuestions.add(q6);
        MultipleChoiceQuestion q7 = new MultipleChoiceQuestion();
        q7.setQuestionName("When does it start?");
        q7.setQuestionCaption("As a reaction to something: someone calls you, someone comes to pick you up, there is a signal");
        q7.setQuestionWriter(appUsers.get(0));
        q7.setQuestionType(QuestionType.MC);
        q7.setQuestionAnswer(new ArrayList<>(Arrays.asList("I know the exact starting time", "I approximately know the starting time", "I decide when it start", "It starts as a reaction to something")));
        mcQuestions.add(q7);
        MultipleChoiceQuestion q8 = new MultipleChoiceQuestion();
        q8.setQuestionName("What happens if you are late?");
        q8.setQuestionCaption("No problem: If you go to a flea market and there is enough time to see everything, it doesn’t matter if you’re running a bit late\n" + "Everything is postponed: If you have to collect stuff to sell on a flea market and you start later, you’ll also finish later\n" + "You miss a part: If there is just enough time to watch the whole market and you want to see everything, you have to miss a part if you’re late\n" + "You miss everything: If there is only one bus per hour to go to the flea market and the flea market is only for an hour, you miss the whole event if you miss that bus\n" + "Burden to others: If you have agreed with someone to sell stuff together at the flea market and you are late, the other will (probably) be disappointed");
        q8.setQuestionWriter(appUsers.get(0));
        q8.setQuestionType(QuestionType.MC);
        q8.setQuestionAnswer(new ArrayList<>(Arrays.asList("No problem", "Everything is postponed", "I will miss a part", "I will miss everything", "I will be a burden to others")));
        mcQuestions.add(q8);
        MultipleChoiceQuestion q9 = new MultipleChoiceQuestion();
        q9.setQuestionName("What happens if you miss it?");
        q9.setQuestionCaption("An example of negative consequences: You want to renew your passport at the last minute before you go on a holiday, but you miss that chance");
        q9.setQuestionWriter(appUsers.get(0));
        q9.setQuestionType(QuestionType.MC);
        q9.setQuestionAnswer(new ArrayList<>(Arrays.asList("It does not matter", "I would pity that", "That has negative consequences", "I will be a burden to others")));
        mcQuestions.add(q9);
        MultipleChoiceQuestion q10 = new MultipleChoiceQuestion();
        q10.setQuestionName("When will it end?");
        q10.setQuestionCaption("If you visit an open day with three rounds, you can usually decide to leave after the second round. Then you can determine the ending time approximately yourself");
        q10.setQuestionWriter(appUsers.get(0));
        q10.setQuestionType(QuestionType.MC);
        q10.setQuestionAnswer(new ArrayList<>(Arrays.asList("The ending time is fixed", "The ending time is not clear (yet)", "I can determine the ending time", "I can approximately determine the ending time", "The ending time is not important")));
        mcQuestions.add(q10);
        MultipleChoiceQuestion q11 = new MultipleChoiceQuestion();
        q11.setQuestionName("What happens when it ends later?");
        q11.setQuestionCaption("Something serious: You miss the last train home");
        q11.setQuestionWriter(appUsers.get(0));
        q11.setQuestionType(QuestionType.MC);
        q11.setQuestionAnswer(new ArrayList<>(Arrays.asList("Nothing (serious)", "Everything after gets postponed", "Something serious")));
        mcQuestions.add(q11);
        MultipleChoiceQuestion q12 = new MultipleChoiceQuestion();
        q12.setQuestionName("Do you have to wait?");
        q12.setQuestionCaption("Do you have to sit in a waiting room first, do you have to wait for the train to arrive, between to rounds, etc.");
        q12.setQuestionWriter(appUsers.get(0));
        q12.setQuestionType(QuestionType.MC);
        q12.setQuestionAnswer(new ArrayList<>(Arrays.asList("No", "A very short time", "Yes")));
        mcQuestions.add(q12);
        MultipleChoiceQuestion q13 = new MultipleChoiceQuestion();
        q13.setQuestionName("Can something change?");
        q13.setQuestionCaption("Do you have to sit in a waiting room first, do you have to wait for the train to arrive, between to rounds, etc.");
        q13.setQuestionWriter(appUsers.get(0));
        q13.setQuestionType(QuestionType.MC);
        q13.setQuestionAnswer(new ArrayList<>(Arrays.asList("No", "Yes, but it is OK", "Yes")));
        mcQuestions.add(q13);
        MultipleChoiceQuestion q14 = new MultipleChoiceQuestion();
        q14.setQuestionName("Do you know what you should do and how to do it?");
        q14.setQuestionCaption("If someone will explain it to you, choose kind of");
        q14.setQuestionWriter(appUsers.get(0));
        q14.setQuestionType(QuestionType.MC);
        q14.setQuestionAnswer(new ArrayList<>(Arrays.asList("No", "Kind of", "Yes, very clearly")));
        mcQuestions.add(q14);
        MultipleChoiceQuestion q15 = new MultipleChoiceQuestion();
        q15.setQuestionName("Does the order of actions matter?");
        q15.setQuestionCaption("If you go somewhere by plane, it’s important to take your passport out of your luggage before you deliver your luggage, or finish your drink before you go through customs. It is not important whether you get some food before or after you deliver your luggage");
        q15.setQuestionWriter(appUsers.get(0));
        q15.setQuestionType(QuestionType.MC);
        q15.setQuestionAnswer(new ArrayList<>(Arrays.asList("No, or there is only one action", "For some actions, it does", "Yes")));
        mcQuestions.add(q15);
        MultipleChoiceQuestion q16 = new MultipleChoiceQuestion();
        q16.setQuestionName("Can you ask for help when needed?");
        q16.setQuestionCaption("The moment you are in the situation");
        q16.setQuestionWriter(appUsers.get(0));
        q16.setQuestionType(QuestionType.MC);
        q16.setQuestionAnswer(new ArrayList<>(Arrays.asList("No, not at all", "No, I do not know where or to whom", "Probably", "Yes, I know exactly where or to whom")));
        mcQuestions.add(q16);
        MultipleChoiceQuestion q17 = new MultipleChoiceQuestion();
        q17.setQuestionName("Do you know what people expect of you?");
        q17.setQuestionCaption("Do people have a certain idea of what you should do or how well you should do it?");
        q17.setQuestionWriter(appUsers.get(0));
        q17.setQuestionType(QuestionType.MC);
        q17.setQuestionAnswer(new ArrayList<>(Arrays.asList("Yes, and I am sure I can live up to that", "Yes, but I am not sure if I can live up to that", "Yes, but I cannot live up to that", "No", "Nothing is expected from me")));
        mcQuestions.add(q17);

        multipleChoiceQuestionRepository.saveAll(mcQuestions);
    }

    public void createMultipleChoiceAnswer() {
        mcAnswers = new ArrayList<>();
        MultipleChoiceAnswer a1 = new MultipleChoiceAnswer();
        a1.setAnswerQuestion(mcQuestions.get(0));
        a1.setAnswerGiven("Yes, the most important people");
        a1.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a1);
        MultipleChoiceAnswer a2 = new MultipleChoiceAnswer();
        a2.setAnswerQuestion(mcQuestions.get(1));
        a2.setAnswerWriter(appUsers.get(0));
        a2.setAnswerGiven("Five to ten people");
        mcAnswers.add(a2);
        MultipleChoiceAnswer a3 = new MultipleChoiceAnswer();
        a3.setAnswerQuestion(mcQuestions.get(2));
        a3.setAnswerGiven("No");
        a3.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a3);
        MultipleChoiceAnswer a4 = new MultipleChoiceAnswer();
        a4.setAnswerQuestion(mcQuestions.get(3));
        a4.setAnswerGiven("Group");
        a4.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a4);
        MultipleChoiceAnswer a5 = new MultipleChoiceAnswer();
        a5.setAnswerQuestion(mcQuestions.get(4));
        a5.setAnswerGiven("Yes");
        a5.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a5);
        MultipleChoiceAnswer a6 = new MultipleChoiceAnswer();
        a6.setAnswerQuestion(mcQuestions.get(5));
        a6.setAnswerGiven("Yes");
        a6.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a6);
        MultipleChoiceAnswer a7 = new MultipleChoiceAnswer();
        a7.setAnswerQuestion(mcQuestions.get(6));
        a7.setAnswerGiven("I know the exact starting time");
        a7.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a7);
        MultipleChoiceAnswer a8 = new MultipleChoiceAnswer();
        a8.setAnswerQuestion(mcQuestions.get(7));
        a8.setAnswerGiven("Everything is postponed");
        a8.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a8);
        MultipleChoiceAnswer a9 = new MultipleChoiceAnswer();
        a9.setAnswerQuestion(mcQuestions.get(8));
        a9.setAnswerGiven("That has negative conseauences");
        a9.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a9);
        MultipleChoiceAnswer a10 = new MultipleChoiceAnswer();
        a10.setAnswerQuestion(mcQuestions.get(9));
        a10.setAnswerGiven("I can approximately determine the ending time");
        a10.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a10);
        MultipleChoiceAnswer a11 = new MultipleChoiceAnswer();
        a11.setAnswerQuestion(mcQuestions.get(10));
        a11.setAnswerGiven("Everything after gets postponed");
        a11.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a11);
        MultipleChoiceAnswer a12 = new MultipleChoiceAnswer();
        a12.setAnswerQuestion(mcQuestions.get(11));
        a12.setAnswerGiven("No");
        a12.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a12);
        MultipleChoiceAnswer a13 = new MultipleChoiceAnswer();
        a13.setAnswerQuestion(mcQuestions.get(12));
        a13.setAnswerGiven("Yes");
        a13.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a13);
        MultipleChoiceAnswer a14 = new MultipleChoiceAnswer();
        a14.setAnswerQuestion(mcQuestions.get(13));
        a14.setAnswerGiven("Kind of");
        a14.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a14);
        MultipleChoiceAnswer a15 = new MultipleChoiceAnswer();
        a15.setAnswerQuestion(mcQuestions.get(14));
        a15.setAnswerGiven("For some actions, it does");
        a15.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a15);
        MultipleChoiceAnswer a16 = new MultipleChoiceAnswer();
        a16.setAnswerQuestion(mcQuestions.get(15));
        a16.setAnswerGiven("Probably");
        a16.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a16);
        MultipleChoiceAnswer a17 = new MultipleChoiceAnswer();
        a17.setAnswerQuestion(mcQuestions.get(16));
        a17.setAnswerGiven("Yes, but I am not sure if I can live up to that");
        a17.setAnswerWriter(appUsers.get(0));
        mcAnswers.add(a17);

        multipleChoiceAnswerRepository.saveAll(mcAnswers);
    }

    public void createOpenQuestion() {
        openQuestions = new ArrayList<>();
        OpenQuestion q1 = new OpenQuestion();
        q1.setQuestionName("Did you gain any new ideas on how to lower your stress level? If yes, which?");
        q1.setQuestionCaption("This question is optional.");
        q1.setQuestionWriter(appUsers.get(0));
        q1.setQuestionType(QuestionType.O);
        openQuestions.add(q1);
        OpenQuestion q2 = new OpenQuestion();
        q2.setQuestionName("Do you have the idea that you would look differently at the situation? If yes, explain.");
        q2.setQuestionCaption("This question is optional.");
        q2.setQuestionWriter(appUsers.get(0));
        q2.setQuestionType(QuestionType.O);
        openQuestions.add(q2);
        OpenQuestion q3 = new OpenQuestion();
        q3.setQuestionName("By using the app, do you look differently to this situation than you did before? If yes, what changed?");
        q3.setQuestionCaption("This question is optional");
        q3.setQuestionWriter(appUsers.get(0));
        q3.setQuestionType(QuestionType.O);
        openQuestions.add(q3);
        OpenQuestion q4 = new OpenQuestion();
        q4.setQuestionName("Was the situation anything different than expected?");
        q4.setQuestionCaption("This question is optional");
        q4.setQuestionWriter(appUsers.get(0));
        q4.setQuestionType(QuestionType.O);
        openQuestions.add(q4);
        OpenQuestion q5 = new OpenQuestion();
        q5.setQuestionName("Would you do the same thing next time a similar situation is bound to happen?");
        q5.setQuestionCaption("This question is optional");
        q5.setQuestionWriter(appUsers.get(0));
        q5.setQuestionType(QuestionType.O);
        openQuestions.add(q5);
        OpenQuestion q6 = new OpenQuestion();
        q6.setQuestionName("Is there anything you would do differently the next time a similar situation is bound to happen?");
        q6.setQuestionCaption("This question is optional");
        q6.setQuestionWriter(appUsers.get(0));
        q6.setQuestionType(QuestionType.O);
        openQuestions.add(q6);
        OpenQuestion q7 = new OpenQuestion();
        q7.setQuestionName("Is there anything you would recommend someone else for a similar situation?");
        q7.setQuestionCaption("This question is optional");
        q7.setQuestionWriter(appUsers.get(0));
        q7.setQuestionType(QuestionType.O);
        openQuestions.add(q7);

        openQuestionRepository.saveAll(openQuestions);
    }

    public void createOpenAnswer() {
        openAnswers = new ArrayList<>();
        OpenAnswer a1 = new OpenAnswer();
        a1.setAnswerQuestion(openQuestions.get(0));
        a1.setAnswerName("No");
        a1.setAnswerGiven("I did not gain any new ideas.");
        a1.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a1);
        OpenAnswer a2 = new OpenAnswer();
        a2.setAnswerQuestion(openQuestions.get(1));
        a2.setAnswerName("Yes");
        a2.setAnswerGiven("I would give myself more time beforehand.");
        a2.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a2);
        OpenAnswer a3 = new OpenAnswer();
        a3.setAnswerQuestion(openQuestions.get(2));
        a3.setAnswerName("Yes");
        a3.setAnswerGiven("The application calms me down when thinking about a situation I have to attend to.");
        a3.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a3);
        OpenAnswer a4 = new OpenAnswer();
        a4.setAnswerQuestion(openQuestions.get(3));
        a4.setAnswerName("Yes");
        a4.setAnswerGiven("It took me less time than expected. Therefore everything else did not have to get postponed.");
        a4.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a4);
        OpenAnswer a5 = new OpenAnswer();
        a5.setAnswerQuestion(openQuestions.get(4));
        a5.setAnswerName("No");
        a5.setAnswerGiven("I would give myself less time than I intentionally thought was needed.");
        a5.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a5);
        OpenAnswer a6 = new OpenAnswer();
        a6.setAnswerQuestion(openQuestions.get(6));
        a6.setAnswerName("Yes");
        a6.setAnswerGiven("Make sure you are prepared for your work and make sure you know what you are doing. Before you start find the person you need whenever you have questions or when you are stuck. You simply don't have to do it alone.");
        a6.setAnswerWriter(appUsers.get(0));
        openAnswers.add(a6);

        openAnswerRepository.saveAll(openAnswers);
    }

    public void createCategory() {
        categories = new ArrayList<>();
        Category c1 = new Category();
        c1.setCategoryName("One on One Conversation");
        c1.setCategoryTitle("One on One Conversation: These are conversations that take place between two to three people.");
        c1.setCategoryWriter(appUsers.get(0));
        c1.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(0))));
        c1.setCategoryImage("https://db3pap006files.storage.live.com/y4mCQxZwWZYfnATELHAM5uRIJmO9aX1bGRaXlh0130sidjHu5i0dRaF5-nWtCVet58YzZ8ztmgAlbeRYWVZXF7H1HaCgzoKd2D1a16f4R4C_pVKLNdbeJF3x9OK-CwSCQN5Wk3kizQkCNMY54dFFSVrLmoi2XHfcA0RmLQkW7YhrNkGmplT92Dd2CPsz-Re3ecw?width=500&height=500&cropmode=none");
        categories.add(c1);
        Category c2 = new Category();
        c2.setCategoryName("Group Talk");
        c2.setCategoryTitle("Group Talk: Online or offline. A group talk is an interaction with multiple people, for example a meeting for work or school.");
        c2.setCategoryWriter(appUsers.get(0));
        c2.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(1))));
        c2.setCategoryImage("https://db3pap006files.storage.live.com/y4mJEp7iDaMfD9Aj_8w7PxK8zaSXB8NbrNZgFsPvI22_V1Zt41UAn8J_hsejdhc6Ve0yPVOBnYOBRa57cCMw0peK08OMgMilQxYOQqS2Mz0AaoNlWKhpjR-Rg8hnlc2Zswzq7rHDtubBS87QUJsYSdo4D-q7IS1vOqxAis-OAjAtO1H6qITxfu3ucUiemLEKBud?width=500&height=500&cropmode=none");
        categories.add(c2);
        Category c3 = new Category();
        c3.setCategoryName("Presentation");
        c3.setCategoryTitle("Presentation: Online or offline. A presentation is a talk where you have to present something to one or more persons.");
        c3.setCategoryWriter(appUsers.get(0));
        c3.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(2))));
        c3.setCategoryImage("https://db3pap006files.storage.live.com/y4mwmYM4knlWVRqEQLjg1Y32VgJ9n0Gfd4llZ-L4B5AvXIkdNhHvX4UlkrTu53HRlrNYVtNS3nOiEoDx7jzF0yK0Xe1KqhvAMtvbjwm4icsKwWs8h5ZmCwGUtdu8TFNGfAW8K3TB_bK6kleklIhzygiK8iL5eoAy0aMUTuZbzSoYR3ZiTvW2gPL102vAPF_x6ai?width=500&height=500&cropmode=none");
        categories.add(c3);
        Category c4 = new Category();
        c4.setCategoryName("Shopping");
        c4.setCategoryTitle("Shopping: You need to a store. This could be for grocery shopping or every other store.");
        c4.setCategoryWriter(appUsers.get(0));
        c4.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(3))));
        c4.setCategoryImage("https://db3pap006files.storage.live.com/y4mdfuZd_J0Y8L6KRCflMG3Hcd0KANX0n7gRJmUJLLxE9dTf_YSkHEV8nIWAkYQufGRv116QFeOerpOQtAwvTPW7bdomgXMQhul7vME63ZGQavaT9zZG0hJki9mohSPKNz__ebgYNTeQa0Oj-GoaRV50CXHJlgLiSUsPW9R5yVp74BillGv_2mIDK_3i31dFzVn?width=500&height=500&cropmode=none");
        categories.add(c4);
        Category c5 = new Category();
        c5.setCategoryName("Convention");
        c5.setCategoryTitle("Convention: You are going to a convention as a visitor or to work.");
        c5.setCategoryWriter(appUsers.get(0));
        c5.setCategorySituation(new ArrayList<>(Arrays.asList(situations.get(4))));
        c5.setCategoryImage("https://db3pap006files.storage.live.com/y4man1uPza2y6Bj5BchBrGt9CoclyE0efGdjyzpdbchgvFRi-j21pEWARLxcUbD_PgW8kzt-us9gDJ28LmklzQ_WK9KTsuwvgFuGiznWCaKhDJvg--J9ngJFTWyWb-LHKaTWB2vIAe34Ui6Tr3fPDCyBu1_WDdfB-fJRoZgOVKIENbLJLhsFojAgP_Fjygm2Umn?width=500&height=500&cropmode=none");
        categories.add(c5);

        categoryRepository.saveAll(categories);
    }

    public void createSituation() {
        situations = new ArrayList<>();
        Situation s1 = new Situation();
        s1.setSituationName("Job Interview");
        s1.setSituationTitle("Job Interview: Online or offline. A job interview is an interview with one or two persons other than yourself.");
        s1.setSituationWriter(appUsers.get(0));
        s1.setSituationImage("https://db3pap006files.storage.live.com/y4mswtsuAyqqPhxzUKBpWrmJYrNlLl5Rr80zBIGK8Dqvf4dNaGyUIG18RXphVUbWYOrvMi0hbWpygox1Rs0rFwBMQHtHxdqttGfqb7G88p0fCiwoL4In7YAnea5jSVtrq-0KwLaR7nKKafmDmnwpPsvludbG9gm-0No4FqkHSouTwIYK6Lk8LOD0dCNN1btIED8?width=500&height=500&cropmode=none");
        s1.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), mcQuestions.get(1), mcQuestions.get(2), mcQuestions.get(3), mcQuestions.get(4), booleanQuestions.get(0), mcQuestions.get(5), mcQuestions.get(6), mcQuestions.get(7), mcQuestions.get(8), mcQuestions.get(9), mcQuestions.get(10), mcQuestions.get(11), mcQuestions.get(12), mcQuestions.get(13), mcQuestions.get(14), mcQuestions.get(15), mcQuestions.get(16))));
//        situationRepository.save(s1);
//        System.out.println("Situation: " + s1.getSituationName() + " is created");
        situations.add(s1);
        Situation s2 = new Situation();
        s2.setSituationName("Team Meeting");
        s2.setSituationTitle("Team Meeting: Online or offline. A team meeting is a meeting with collegues, this could be an online or offline meeting.");
        s2.setSituationWriter(appUsers.get(0));
        s2.setSituationImage("https://db3pap006files.storage.live.com/y4mIUBIzj66WQXTVUqiOWwZ0nmHYHaZ1Of3UOcyuygjBf4SFFtHXtic7IfFmzl09XdJCmsAQH-xvL5T3RfvwJI24SmsR_lnePHjudyXG3I1RdLEySPYrCznxIoqCMbkaHyG_BV7vCBKrWTaNHHk4cl2NUK3z6KJ0c_T_MHApM85uXI4OoVvIG0tzq04MStEaVNE?width=500&height=500&cropmode=none");
        s2.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), mcQuestions.get(1), mcQuestions.get(2), mcQuestions.get(3), mcQuestions.get(4), booleanQuestions.get(0), mcQuestions.get(5), mcQuestions.get(6), mcQuestions.get(7), mcQuestions.get(8), mcQuestions.get(9), mcQuestions.get(10), mcQuestions.get(11), mcQuestions.get(12), mcQuestions.get(13), mcQuestions.get(14), mcQuestions.get(15), mcQuestions.get(16))));
//        situationRepository.save(s2);
//        System.out.println("Situation: " + s2.getSituationName() + " is created");
        situations.add(s2);
        Situation s3 = new Situation();
        s3.setSituationName("Offline Presentation");
        s3.setSituationTitle("Offline Presentation: You have to give an offline presentation. For example present an idea to colleagues or class mates.");
        s3.setSituationWriter(appUsers.get(0));
        s3.setSituationImage("https://db3pap006files.storage.live.com/y4mVbRxRomm_qfvKuEyPf5hUy4DlPlWm4s_6_oxYnFjzVrV4MC5fyY-F-N186lY-3HWvr1uIqLrVSWGdwuHoJptXRdlZRc4C0fQAZHGXzXVajsD2XXG3BcawuTFWeMm2B93vZ7jX0QkadcdHEtrMX46J9_xWUIMIguC90goLzsuPuW9yy3vy4w3l5ltAqKrKaJR?width=500&height=500&cropmode=none");
        s3.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), mcQuestions.get(1), mcQuestions.get(2), mcQuestions.get(3), mcQuestions.get(4), booleanQuestions.get(0), mcQuestions.get(5), mcQuestions.get(6), mcQuestions.get(7), mcQuestions.get(8), mcQuestions.get(9), mcQuestions.get(10), mcQuestions.get(11), mcQuestions.get(12), mcQuestions.get(13), mcQuestions.get(14), mcQuestions.get(15), mcQuestions.get(16))));
//        situationRepository.save(s3);
//        System.out.println("Situation: " + s3.getSituationName() + " is created");
        situations.add(s3);
        Situation s4 = new Situation();
        s4.setSituationName("Grocery Shopping");
        s4.setSituationTitle("Grocery Shopping: You need to go out to the grocery store to do your grocery shopping.");
        s4.setSituationWriter(appUsers.get(0));
        s4.setSituationImage("https://db3pap006files.storage.live.com/y4mLIRnkn21QWDK5neVIsd1nUvP4jCxWSgB0cLnfEutq9im1Uy88WGtl4HSZKi7-eYl86lm3ZvZPOHwRpYtbgAW27o3aLk749GUivsdtw1F6EujpFPy5ynS-ljgbUCbVwW6jzbkNQ0vSU9LXegKemAJWxz5YTMs4PkAdDZXxBuyOlTTMoOUJtUyTaysghKIbni8?width=500&height=500&cropmode=none");
        s4.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), mcQuestions.get(1), mcQuestions.get(2), mcQuestions.get(3), mcQuestions.get(4), booleanQuestions.get(0), mcQuestions.get(5), mcQuestions.get(6), mcQuestions.get(7), mcQuestions.get(8), mcQuestions.get(9), mcQuestions.get(10), mcQuestions.get(11), mcQuestions.get(12), mcQuestions.get(13), mcQuestions.get(14), mcQuestions.get(15), mcQuestions.get(16))));
//        situationRepository.save(s4);
//        System.out.println("Situation: " + s4.getSituationName() + " is created");
        situations.add(s4);
        Situation s5 = new Situation();
        s5.setSituationName("Visit a Convention");
        s5.setSituationTitle("Visiti a Convention: You are going to a convention as a visitor. This could be alone or with friends.");
        s5.setSituationWriter(appUsers.get(0));
        s5.setSituationImage("https://db3pap006files.storage.live.com/y4myaO1vUE_RvztrieU_6ep46WQPxEyDRtB0UmP57pZltz9cEYmCBCYINfkYs1R0bZUuO84EZ9LasEbYLxdJidRUuN-sln31yqCaRZg3-t0avsX9M5uQf_s-21QOVIbLo54KPoetfI-mbqvHBNcd8T1w0qErX81IQJkk4zuGSh2YTjdt6bV-t6rg_M2HCrysNBc?width=500&height=500&cropmode=none");
        s5.setSituationQuestion(new ArrayList<>(Arrays.asList(mcQuestions.get(0), mcQuestions.get(1), mcQuestions.get(2), mcQuestions.get(3), mcQuestions.get(4), booleanQuestions.get(0), mcQuestions.get(5), mcQuestions.get(6), mcQuestions.get(7), mcQuestions.get(8), mcQuestions.get(9), mcQuestions.get(10), mcQuestions.get(11), mcQuestions.get(12), mcQuestions.get(13), mcQuestions.get(14), mcQuestions.get(15), mcQuestions.get(16))));
//        situationRepository.save(s5);
//        System.out.println("Situation: " + s5.getSituationName() + " is created");
        situations.add(s5);

        situationRepository.saveAll(situations);
    }

    public void createMultipleAnswerQuestion() {
        maQuestions = new ArrayList<>();
        MultipleAnswerQuestion q1 = new MultipleAnswerQuestion();
        q1.setQuestionName("What would you like to see change within the application?");
        q1.setQuestionCaption("Would you like to see more situations? More categories? Maybe something about the lay-out?");
        q1.setQuestionAnswer(new ArrayList<>(Arrays.asList("More situations", "More categories", "Different lay-out", "Chat functionality", "Something else")));
        q1.setQuestionWriter(appUsers.get(0));
        q1.setQuestionType(QuestionType.MA);
        maQuestions.add(q1);
        MultipleAnswerQuestion q2 = new MultipleAnswerQuestion();
        q2.setQuestionName("With what did the application help you the most?");
        q2.setQuestionCaption("Multiple answers are possible.");
        q2.setQuestionAnswer(new ArrayList<>(Arrays.asList("It gave me some time to think about a situation", "It helped me rationalize the situation", "It helped me understand the situation more", "It gave me more self perspective", "Nothing", "Something else")));
        q2.setQuestionWriter(appUsers.get(0));
        q2.setQuestionType(QuestionType.MA);
        maQuestions.add(q2);
        MultipleAnswerQuestion q3 = new MultipleAnswerQuestion();
        q3.setQuestionName("What would you like to tell other users about this application?");
        q3.setQuestionCaption("Multiple answers are possible.");
        q3.setQuestionAnswer(new ArrayList<>(Arrays.asList("It helps you think over a situation", "It helps you rationalize a situation", "It helps you understand your fears", "It gives you comfort", "Nothing", "Something else")));
        q3.setQuestionWriter(appUsers.get(0));
        q3.setQuestionType(QuestionType.MA);
        maQuestions.add(q3);

        multipleAnswerQuestionRepository.saveAll(maQuestions);
    }

    public void createMultipleAnswerAnswer() {
        maAnswers = new ArrayList<>();
        MultipleAnswerAnswer a1 = new MultipleAnswerAnswer();
        a1.setAnswerQuestion(maQuestions.get(0));
        a1.setAnswerGiven(new ArrayList<>(Arrays.asList("More situations", "More categories", "Different lay-out")));
        a1.setAnswerWriter(appUsers.get(0));
        maAnswers.add(a1);
        MultipleAnswerAnswer a2 = new MultipleAnswerAnswer();
        a2.setAnswerQuestion(maQuestions.get(1));
        a2.setAnswerGiven(new ArrayList<>(Arrays.asList("It gave me some time to think about a situation", "It helped me rationalize the situation")));
        a2.setAnswerWriter(appUsers.get(0));
        maAnswers.add(a2);
        MultipleAnswerAnswer a3 = new MultipleAnswerAnswer();
        a3.setAnswerQuestion(maQuestions.get(2));
        a3.setAnswerGiven(new ArrayList<>(Arrays.asList("It helps you think over a situation", "It helps you rationalize a situation")));
        a3.setAnswerWriter(appUsers.get(0));
        maAnswers.add(a3);

        multipleAnswerAnswerRepository.saveAll(maAnswers);
    }

    public void createScore() {
        scores = new ArrayList<>();
        Score s1 = new Score();
        s1.setGivenBy(appUsers.get(0));
        s1.setFeelScore(Mood.NEUTRAL);
        s1.setGivenScore(6);
        s1.setHelpful(true);
        s1.setTipDo("Make sure you are on time and know what to do.");
        s1.setTipDont("Do not show up late and unprepared.");
        scores.add(s1);
        Score s2 = new Score();
        s2.setGivenBy(appUsers.get(0));
        s2.setFeelScore(Mood.HAPPY);
        s2.setGivenScore(9);
        s2.setHelpful(true);
        s2.setTipDo("Make eye contact, speak up and speak clearly. Do not lie, it is not bad to do not know something. You are allowed to make mistakes.");
        s2.setTipDont("Do not lie. Whenever you are in a job interview, do not try to make things better than they are, eventually they will find out.");
        scores.add(s2);
        Score s3 = new Score();
        s3.setGivenBy(appUsers.get(0));
        s3.setFeelScore(Mood.SAD);
        s3.setGivenScore(3);
        s3.setHelpful(false);
        s3.setTipDo("");
        s3.setTipDont("");
        scores.add(s3);
        Score s4 = new Score();
        s4.setGivenBy(appUsers.get(0));
        s4.setFeelScore(Mood.SAD);
        s4.setGivenScore(2);
        s4.setHelpful(false);
        s4.setTipDo("Get on time, be nice");
        s4.setTipDont("Get to late, give them nicknames or get there in your summer outfit");
        scores.add(s4);
        Score s5 = new Score();
        s5.setGivenBy(appUsers.get(0));
        s5.setFeelScore(Mood.NEUTRAL);
        s5.setGivenScore(6);
        s5.setHelpful(false);
        s5.setTipDo("Participate in the team meeting and speak up when there's a task assigned to you that you cannot do");
        s5.setTipDont("Do not sit in silence");
        scores.add(s5);
        Score s6 = new Score();
        s6.setGivenBy(appUsers.get(0));
        s6.setFeelScore(Mood.HAPPY);
        s6.setGivenScore(8);
        s6.setHelpful(true);
        s6.setTipDo("At the beginning of your presentation, say that they need to park their questions. You will handle them at the end of the presentation");
        s6.setTipDont("Do not come unprepared!");
        scores.add(s6);
        Score s7 = new Score();
        s7.setGivenBy(appUsers.get(0));
        s7.setFeelScore(Mood.SAD);
        s7.setGivenScore(4);
        s7.setHelpful(true);
        s7.setTipDo("Make a presentation that most people will understand by looking at it. You will have to talk them through it but they will have to see what you are talking about.");
        s7.setTipDont("Your presentation should not raise questions, the things you tell should raise questions.");
        scores.add(s7);
        Score s8 = new Score();
        s8.setGivenBy(appUsers.get(0));
        s8.setFeelScore(Mood.HAPPY);
        s8.setGivenScore(10);
        s8.setHelpful(true);
        s8.setTipDo("Do online grocery shopping. That way you can add groceries in your basket during the week and place your order whenever your are out of groceries at home.");
        s8.setTipDont("Do grocery shopping in the supermarket, especially with the Covid-19 virus it is no blast.");
        scores.add(s8);
        Score s9 = new Score();
        s9.setGivenBy(appUsers.get(0));
        s9.setFeelScore(Mood.HAPPY);
        s9.setGivenScore(10);
        s9.setHelpful(false);
        s9.setTipDo("Go with friends");
        s9.setTipDont("Come late, all the good merchandise will be sold out");
        scores.add(s9);
        Score s10 = new Score();
        s10.setGivenBy(appUsers.get(0));
        s10.setFeelScore(Mood.NEUTRAL);
        s10.setGivenScore(5);
        s10.setHelpful(true);
        s10.setTipDo("Decide a plan beforehand, that way you will not get caught up in the crowd");
        s10.setTipDont("Do not go without a goal, that way you will stray around all day not knowing what you need or have to do.");
        scores.add(s10);

        scoreRepository.saveAll(scores);
    }

    public void createTip() {
        tips = new ArrayList<>();
        Tip t1 = new Tip();
        t1.setTipName("Be prepared");
        t1.setTipTitle("Prepare yourself and look into the company you are going to and make sure to be on time.");
        t1.setTipDate(new Date());
        t1.setTipPublished(true);
        t1.setTipScore(scores.get(0));
        t1.setTipWriter(appUsers.get(0));
        t1.setTipSituation(situations.get(0));
//        tipRepository.save(t1);
//        System.out.println("Tip1 is created");
        tips.add(t1);
        Tip t2 = new Tip();
        t2.setTipDate(new Date());
        t2.setTipPublished(true);
        t2.setTipScore(scores.get(1));
        t2.setTipWriter(appUsers.get(0));
        t2.setTipSituation(situations.get(1));
        t2.setTipName("You are in it together");
        t2.setTipTitle("Do not forget you are in a team and work together, you can ask each other everything. You all have the same goal.");
//        tipRepository.save(t2);
//        System.out.println("Tip2 is created");
        tips.add(t2);
        Tip t3 = new Tip();
        t3.setTipDate(new Date());
        t3.setTipPublished(true);
        t3.setTipScore(scores.get(2));
        t3.setTipWriter(appUsers.get(0));
        t3.setTipSituation(situations.get(3));
        t3.setTipName("Don't like it");
        t3.setTipTitle("Don't like to do grocery shopping");
//        tipRepository.save(t3);
//        System.out.println("Tip3 is created");
        tips.add(t3);
        Tip t4 = new Tip();
        t4.setTipDate(new Date());
        t4.setTipPublished(true);
        t4.setTipScore(scores.get(3));
        t4.setTipWriter(appUsers.get(0));
        t4.setTipSituation(situations.get(0));
        t4.setTipName("Be nice and representative");
        t4.setTipTitle("You can make a lot of bad choices, clothing is one of them");
        tips.add(t4);
        Tip t5 = new Tip();
        t5.setTipDate(new Date());
        t5.setTipPublished(true);
        t5.setTipScore(scores.get(4));
        t5.setTipWriter(appUsers.get(0));
        t5.setTipSituation(situations.get(1));
        t5.setTipName("Participate in meetings");
        t5.setTipTitle("You're in a team, and every member is a valuable member of it");
        tips.add(t5);
        Tip t6 = new Tip();
        t6.setTipDate(new Date());
        t6.setTipPublished(true);
        t6.setTipScore(scores.get(5));
        t6.setTipWriter(appUsers.get(0));
        t6.setTipSituation(situations.get(2));
        t6.setTipName("Prepare your presentation");
        t6.setTipTitle("A good preparation is half the work");
        tips.add(t6);
        Tip t7 = new Tip();
        t7.setTipDate(new Date());
        t7.setTipPublished(true);
        t7.setTipScore(scores.get(6));
        t7.setTipWriter(appUsers.get(0));
        t7.setTipSituation(situations.get(2));
        t7.setTipName("A good presentation is everything");
        t7.setTipTitle("As long as people understand your presentation and the slides it goes automatically");
        tips.add(t7);
        Tip t8 = new Tip();
        t8.setTipDate(new Date());
        t8.setTipPublished(true);
        t8.setTipScore(scores.get(7));
        t8.setTipWriter(appUsers.get(0));
        t8.setTipSituation(situations.get(3));
        t8.setTipName("Online grocery shopping");
        t8.setTipTitle("Doing your grocery shopping online gives you more control");
        tips.add(t8);
        Tip t9 = new Tip();
        t9.setTipDate(new Date());
        t9.setTipPublished(true);
        t9.setTipScore(scores.get(8));
        t9.setTipWriter(appUsers.get(0));
        t9.setTipSituation(situations.get(4));
        t9.setTipName("Go with friends");
        t9.setTipTitle("Going with friends makes it a great experience");
        tips.add(t9);
        Tip t10 = new Tip();
        t10.setTipDate(new Date());
        t10.setTipPublished(true);
        t10.setTipScore(scores.get(9));
        t10.setTipWriter(appUsers.get(0));
        t10.setTipSituation(situations.get(4));
        t10.setTipName("Plan your visit");
        t10.setTipTitle("Planning your visit in advance will win you time.");
        tips.add(t10);

        tipRepository.saveAll(tips);
    }

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
