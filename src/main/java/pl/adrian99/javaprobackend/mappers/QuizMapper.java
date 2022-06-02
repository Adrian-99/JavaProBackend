package pl.adrian99.javaprobackend.mappers;

import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.dtos.QuizAnswerDto;
import pl.adrian99.javaprobackend.dtos.QuizCategoryDto;
import pl.adrian99.javaprobackend.dtos.QuizQuestionDto;
import pl.adrian99.javaprobackend.entities.QuizAnswer;
import pl.adrian99.javaprobackend.entities.QuizCategory;
import pl.adrian99.javaprobackend.entities.QuizQuestion;

import java.util.List;

@Component
public class QuizMapper {

    public List<QuizCategoryDto> fromQuizCategoryToDto(List<QuizCategory> categories) {
        return categories.stream().map(this::fromQuizCategoryToDto).toList();
    }

    public QuizCategoryDto fromQuizCategoryToDto(QuizCategory category) {
        return new QuizCategoryDto(category.getId(), category.getName());
    }

    public List<QuizQuestionDto> fromQuizQuestionToDto(List<QuizQuestion> questions) {
        return questions.stream().map(this::fromQuizQuestionToDto).toList();
    }

    public QuizQuestionDto fromQuizQuestionToDto(QuizQuestion question) {
        return new QuizQuestionDto(question.getId(), question.getQuestion(), question.getImage() != null, fromQuizAnswerToDto(question.getAnswers()));
    }

    public List<QuizAnswerDto> fromQuizAnswerToDto(List<QuizAnswer> answers) {
        return answers.stream().map(this::fromQuizAnswerToDto).toList();
    }

    public QuizAnswerDto fromQuizAnswerToDto(QuizAnswer answer) {
        return new QuizAnswerDto(answer.getId(), answer.getAnswer());
    }
}
