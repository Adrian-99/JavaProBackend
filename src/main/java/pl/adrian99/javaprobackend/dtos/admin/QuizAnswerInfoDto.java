package pl.adrian99.javaprobackend.dtos.admin;

import lombok.Data;

@Data
public class QuizAnswerInfoDto {
    private String answer;
    private Boolean isCorrect;
    private Long questionId;
}
