package pl.adrian99.javaprobackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CodeExampleDto {
    private String name;
    private String context;
    private List<CodeDto> codes;
}
