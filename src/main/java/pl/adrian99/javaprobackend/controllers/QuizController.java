package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.dtos.AnswersValidationDto;
import pl.adrian99.javaprobackend.dtos.AnswersValidationResultDto;
import pl.adrian99.javaprobackend.dtos.QuizCategoryDto;
import pl.adrian99.javaprobackend.dtos.QuizQuestionDto;
import pl.adrian99.javaprobackend.entities.QuizQuestion;
import pl.adrian99.javaprobackend.mappers.QuizMapper;
import pl.adrian99.javaprobackend.services.QuizService;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private final QuizMapper quizMapper;

    @GetMapping("categories")
    public List<QuizCategoryDto> getCategories() {
        var categories = quizService.getCategories();
        return quizMapper.fromQuizCategoryToDto(categories);
    }

    @GetMapping("questions/{categoryId}")
    public List<QuizQuestionDto> getQuestions(@PathVariable Long categoryId) {
        var questions = quizService.getQuestions(categoryId);
        return quizMapper.fromQuizQuestionToDto(questions);
    }

    @GetMapping("questions/image/{questionId}")
    public byte[] getQuestionImage(@PathVariable Long questionId) {
        return quizService.getQuestionImage(questionId);
    }

    @PostMapping("answers/{questionId}/validate")
    public AnswersValidationResultDto validateAnswers(@PathVariable Long questionId, @RequestBody AnswersValidationDto answersValidationDto) {
        return new AnswersValidationResultDto(
                quizService.validateAnswers(questionId, answersValidationDto.getCheckedAnswerIds())
        );
    }

    @PostMapping("questions/{categoryId}")
    public QuizQuestion addQuestion(@PathVariable Long categoryId,
                                    @RequestParam String question,
                                    @RequestParam(required = false) MultipartFile image) throws IOException {
        return quizService.addQuestion(categoryId, question, image);
    }
}
