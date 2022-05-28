package pl.adrian99.javaprobackend.initializers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.entities.QuizAnswer;
import pl.adrian99.javaprobackend.entities.QuizCategory;
import pl.adrian99.javaprobackend.entities.QuizQuestion;
import pl.adrian99.javaprobackend.repositories.QuizAnswerRepository;
import pl.adrian99.javaprobackend.repositories.QuizCategoryRepository;
import pl.adrian99.javaprobackend.repositories.QuizQuestionRepository;

@Component
@RequiredArgsConstructor
public class QuizInitializer implements ApplicationRunner {

    private final QuizCategoryRepository quizCategoryRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizAnswerRepository quizAnswerRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (quizCategoryRepository.count() == 0 &&
            quizQuestionRepository.count() == 0 &&
            quizAnswerRepository.count() == 0) {
            var category = new QuizCategory();
            category.setName("Test Java");
            quizCategoryRepository.save(category);

            var question1 = new QuizQuestion();
            question1.setCategory(category);
            question1.setQuestion("Pakiet biblioteki Swing?");
            quizQuestionRepository.save(question1);

            var answer11 = new QuizAnswer();
            answer11.setQuestion(question1);
            answer11.setAnswer("java.swing");
            answer11.setCorrect(false);
            quizAnswerRepository.save(answer11);
            var answer12 = new QuizAnswer();
            answer12.setQuestion(question1);
            answer12.setAnswer("java.awt");
            answer12.setCorrect(false);
            quizAnswerRepository.save(answer12);
            var answer13 = new QuizAnswer();
            answer13.setQuestion(question1);
            answer13.setAnswer("javax.swing");
            answer13.setCorrect(true);
            quizAnswerRepository.save(answer13);
            var answer14 = new QuizAnswer();
            answer14.setQuestion(question1);
            answer14.setAnswer("javax.awt");
            answer14.setCorrect(false);
            quizAnswerRepository.save(answer14);

            var question2 = new QuizQuestion();
            question2.setCategory(category);
            question2.setQuestion("Która technologia jest związana z JavaFX?");
            quizQuestionRepository.save(question2);

            var answer21 = new QuizAnswer();
            answer21.setQuestion(question2);
            answer21.setAnswer("JSP");
            answer21.setCorrect(false);
            quizAnswerRepository.save(answer21);
            var answer22 = new QuizAnswer();
            answer22.setQuestion(question2);
            answer22.setAnswer("FXML");
            answer22.setCorrect(true);
            quizAnswerRepository.save(answer22);
            var answer23 = new QuizAnswer();
            answer23.setQuestion(question2);
            answer23.setAnswer("JSF");
            answer23.setCorrect(false);
            quizAnswerRepository.save(answer23);
            var answer24 = new QuizAnswer();
            answer24.setQuestion(question2);
            answer24.setAnswer("EJB");
            answer24.setCorrect(false);
            quizAnswerRepository.save(answer24);

            var question3 = new QuizQuestion();
            question3.setCategory(category);
            question3.setQuestion("Który pakiet związany jest z serwletami?");
            quizQuestionRepository.save(question3);

            var answer31 = new QuizAnswer();
            answer31.setQuestion(question3);
            answer31.setAnswer("javax.servlet");
            answer31.setCorrect(true);
            quizAnswerRepository.save(answer31);
            var answer32 = new QuizAnswer();
            answer32.setQuestion(question3);
            answer32.setAnswer("java.servlet");
            answer32.setCorrect(false);
            quizAnswerRepository.save(answer32);
            var answer33 = new QuizAnswer();
            answer33.setQuestion(question3);
            answer33.setAnswer("javaee.servlet");
            answer33.setCorrect(false);
            quizAnswerRepository.save(answer33);
            var answer34 = new QuizAnswer();
            answer34.setQuestion(question3);
            answer34.setAnswer("javae.servlet");
            answer34.setCorrect(false);
            quizAnswerRepository.save(answer34);

            var question4 = new QuizQuestion();
            question4.setCategory(category);
            question4.setQuestion("Który pakiet związany jest z platformą Android?");
            quizQuestionRepository.save(question4);

            var answer41 = new QuizAnswer();
            answer41.setQuestion(question4);
            answer41.setAnswer("javax.android");
            answer41.setCorrect(false);
            quizAnswerRepository.save(answer41);
            var answer42 = new QuizAnswer();
            answer42.setQuestion(question4);
            answer42.setAnswer("java.android");
            answer42.setCorrect(false);
            quizAnswerRepository.save(answer42);
            var answer43 = new QuizAnswer();
            answer43.setQuestion(question4);
            answer43.setAnswer("android.java");
            answer43.setCorrect(false);
            quizAnswerRepository.save(answer43);
            var answer44 = new QuizAnswer();
            answer44.setQuestion(question4);
            answer44.setAnswer("android.app");
            answer44.setCorrect(true);
            quizAnswerRepository.save(answer44);

            var question5 = new QuizQuestion();
            question5.setCategory(category);
            question5.setQuestion("Która technologia jest bezpośrednio związana z obsługą transakcji?");
            quizQuestionRepository.save(question5);

            var answer51 = new QuizAnswer();
            answer51.setQuestion(question5);
            answer51.setAnswer("JDBC");
            answer51.setCorrect(false);
            quizAnswerRepository.save(answer51);
            var answer52 = new QuizAnswer();
            answer52.setQuestion(question5);
            answer52.setAnswer("EJB");
            answer52.setCorrect(false);
            quizAnswerRepository.save(answer52);
            var answer53 = new QuizAnswer();
            answer53.setQuestion(question5);
            answer53.setAnswer("JTA");
            answer53.setCorrect(true);
            quizAnswerRepository.save(answer53);
            var answer54 = new QuizAnswer();
            answer54.setQuestion(question5);
            answer54.setAnswer("JPA");
            answer54.setCorrect(false);
            quizAnswerRepository.save(answer54);

            quizCategoryRepository.flush();
            quizQuestionRepository.flush();
            quizAnswerRepository.flush();
        }
    }
}
