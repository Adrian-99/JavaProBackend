package pl.adrian99.javaprobackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AnswersValidationDto {
    private List<Long> checkedAnswerIds;
}
