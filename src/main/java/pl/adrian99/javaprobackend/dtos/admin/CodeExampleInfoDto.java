package pl.adrian99.javaprobackend.dtos.admin;

import lombok.Data;

@Data
public class CodeExampleInfoDto {
    private String name;
    private String context;
    private Integer exampleOrder;
    private Long categoryId;
}
