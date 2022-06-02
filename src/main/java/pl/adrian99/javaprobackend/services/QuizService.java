package pl.adrian99.javaprobackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.entities.QuizAnswer;
import pl.adrian99.javaprobackend.entities.QuizCategory;
import pl.adrian99.javaprobackend.entities.QuizQuestion;
import pl.adrian99.javaprobackend.repositories.QuizCategoryRepository;
import pl.adrian99.javaprobackend.repositories.QuizQuestionRepository;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizCategoryRepository quizCategoryRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    public List<QuizCategory> getCategories() {
        return quizCategoryRepository.findAll();
    }

    public List<QuizQuestion> getQuestions(Long categoryId) {
        var category = quizCategoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get().getQuestions();
        } else {
            throw new EntityNotFoundException("Category with id " + categoryId + " not found");
        }
    }

    public byte[] getQuestionImage(Long questionId) {
        var question = quizQuestionRepository.findById(questionId);
        if (question.isPresent()) {
            return question.get().getImage();
        } else {
            throw new EntityNotFoundException("Question with id " + questionId + " not found");
        }
    }

    public boolean validateAnswers(Long questionId, List<Long> checkedAnswerIds) {
        var question = quizQuestionRepository.findById(questionId);
        if (question.isPresent()) {
            var correctAnswerIds = question.get().getAnswers().stream()
                    .filter(QuizAnswer::isCorrect)
                    .map(QuizAnswer::getId)
                    .toList();
            return correctAnswerIds.size() == checkedAnswerIds.size() &&
                    new HashSet<>(checkedAnswerIds).containsAll(correctAnswerIds);
        } else {
            throw new EntityNotFoundException("Question with id " + questionId + " not found");
        }
    }

    public QuizQuestion addQuestion(Long categoryId, String question, MultipartFile image) throws IOException {
        var category = quizCategoryRepository.findById(categoryId);
        if (category.isPresent()) {
            var quizQuestion = new QuizQuestion();
            quizQuestion.setCategory(category.get());
            quizQuestion.setQuestion(question);
            if (image != null) {
                quizQuestion.setImage(image.getBytes());
            }
            quizQuestionRepository.saveAndFlush(quizQuestion);
            return quizQuestion;
        } else {
            throw new EntityNotFoundException("Category with id " + categoryId + " not found");
        }
    }
}
