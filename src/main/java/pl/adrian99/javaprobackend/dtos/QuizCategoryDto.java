package pl.adrian99.javaprobackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizCategoryDto {
    private Long id;
    private String name;
}
