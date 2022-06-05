package pl.adrian99.javaprobackend.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.dtos.admin.QuizAnswerInfoDto;
import pl.adrian99.javaprobackend.entities.QuizAnswer;
import pl.adrian99.javaprobackend.utils.AdminUtils;
import pl.adrian99.javaprobackend.dtos.admin.QuizCategoryInfoDto;
import pl.adrian99.javaprobackend.entities.QuizCategory;
import pl.adrian99.javaprobackend.entities.QuizQuestion;
import pl.adrian99.javaprobackend.repositories.QuizAnswerRepository;
import pl.adrian99.javaprobackend.repositories.QuizCategoryRepository;
import pl.adrian99.javaprobackend.repositories.QuizQuestionRepository;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("admin/quiz")
@RequiredArgsConstructor
public class QuizAdminController {

    private final QuizCategoryRepository quizCategoryRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizAnswerRepository quizAnswerRepository;

    @GetMapping("categories")
    public List<QuizCategory> getCategories() {
        return quizCategoryRepository.findAll();
    }

    @GetMapping("categories/{categoryId}")
    public QuizCategory getCategory(@PathVariable Long categoryId) {
        return AdminUtils.getEntityOrThrow(QuizCategory.class, quizCategoryRepository, categoryId);
    }

    @PostMapping("categories")
    @ResponseStatus(HttpStatus.CREATED)
    public QuizCategory createCategory(@RequestBody QuizCategoryInfoDto quizCategoryInfoDto) {
        var category = new QuizCategory();
        category.setName(quizCategoryInfoDto.getName());
        quizCategoryRepository.saveAndFlush(category);
        return category;
    }

    @PutMapping("categories/{categoryId}")
    public QuizCategory updateCategory(@PathVariable Long categoryId,
                                       @RequestBody QuizCategoryInfoDto quizCategoryInfoDto) {
        var category = AdminUtils.getEntityOrThrow(QuizCategory.class, quizCategoryRepository, categoryId);
        category.setName(quizCategoryInfoDto.getName());
        return category;
    }

    @DeleteMapping("categories/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {
        var category = AdminUtils.getEntityOrThrow(QuizCategory.class, quizCategoryRepository, categoryId);
        quizCategoryRepository.delete(category);
    }

    @GetMapping("questions")
    public List<QuizQuestion> getQuestions() {
        return quizQuestionRepository.findAll();
    }

    @GetMapping("questions/{questionId}")
    public QuizQuestion getQuestion(@PathVariable Long questionId) {
        return AdminUtils.getEntityOrThrow(QuizQuestion.class, quizQuestionRepository, questionId);
    }

    @PostMapping("questions")
    @ResponseStatus(HttpStatus.CREATED)
    public QuizQuestion addQuestion(@RequestParam String question,
                                    @RequestParam Long categoryId,
                                    @RequestParam(required = false) MultipartFile image) throws IOException {
        var category = AdminUtils.getEntityOrThrow(QuizCategory.class, quizCategoryRepository, categoryId);
        var quizQuestion = new QuizQuestion();
        quizQuestion.setCategory(category);
        quizQuestion.setQuestion(question);
        quizQuestion.setImage(image != null ? image.getBytes() : null);
        quizQuestionRepository.saveAndFlush(quizQuestion);
        return quizQuestion;
    }

    @PutMapping("questions/{questionId}")
    public QuizQuestion updateQuestion(@PathVariable Long questionId,
                                       @RequestParam String question,
                                       @RequestParam Long categoryId,
                                       @RequestParam(required = false) MultipartFile image) throws IOException {
        var quizQuestion = AdminUtils.getEntityOrThrow(QuizQuestion.class, quizQuestionRepository, questionId);
        var category = AdminUtils.getEntityOrThrow(QuizCategory.class, quizCategoryRepository, categoryId);
        quizQuestion.setCategory(category);
        quizQuestion.setQuestion(question);
        quizQuestion.setImage(image != null ? image.getBytes() : null);
        quizQuestionRepository.saveAndFlush(quizQuestion);
        return quizQuestion;
    }

    @DeleteMapping("questions/{questionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable Long questionId) {
        var quizQuestion = AdminUtils.getEntityOrThrow(QuizQuestion.class, quizQuestionRepository, questionId);
        quizQuestionRepository.delete(quizQuestion);
    }

    @GetMapping("answers")
    public List<QuizAnswer> getAnswers() {
        return quizAnswerRepository.findAll();
    }

    @GetMapping("answers/{answerId}")
    public QuizAnswer getAnswer(@PathVariable Long answerId) {
        return AdminUtils.getEntityOrThrow(QuizAnswer.class, quizAnswerRepository, answerId);
    }

    @PostMapping("answers")
    @ResponseStatus(HttpStatus.CREATED)
    public QuizAnswer createAnswer(@RequestBody QuizAnswerInfoDto quizAnswerInfoDto) {
        var question = AdminUtils.getEntityOrThrow(
                QuizQuestion.class,
                quizQuestionRepository,
                quizAnswerInfoDto.getQuestionId()
        );
        var answer = new QuizAnswer();
        answer.setAnswer(quizAnswerInfoDto.getAnswer());
        answer.setCorrect(quizAnswerInfoDto.getIsCorrect());
        answer.setQuestion(question);
        quizAnswerRepository.saveAndFlush(answer);
        return answer;
    }

    @PutMapping("answers/{answerId}")
    public QuizAnswer updateAnswer(@PathVariable Long answerId, @RequestBody QuizAnswerInfoDto quizAnswerInfoDto) {
        var answer = AdminUtils.getEntityOrThrow(QuizAnswer.class, quizAnswerRepository, answerId);
        var question = AdminUtils.getEntityOrThrow(
                QuizQuestion.class,
                quizQuestionRepository,
                quizAnswerInfoDto.getQuestionId()
        );
        answer.setAnswer(quizAnswerInfoDto.getAnswer());
        answer.setCorrect(quizAnswerInfoDto.getIsCorrect());
        answer.setQuestion(question);
        quizAnswerRepository.saveAndFlush(answer);
        return answer;
    }

    @DeleteMapping("answers/{answerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswer(@PathVariable Long answerId) {
        var answer = AdminUtils.getEntityOrThrow(QuizAnswer.class, quizAnswerRepository, answerId);
        quizAnswerRepository.delete(answer);
    }
}
