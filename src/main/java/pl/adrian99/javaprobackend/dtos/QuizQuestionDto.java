package pl.adrian99.javaprobackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuizQuestionDto {
    private Long id;
    private String question;
    private boolean hasImage;
    private List<QuizAnswerDto> answers;
}
