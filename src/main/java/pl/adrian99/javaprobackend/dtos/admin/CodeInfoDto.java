package pl.adrian99.javaprobackend.dtos.admin;

import lombok.Data;

@Data
public class CodeInfoDto {
    private String name;
    private String code;
    private Integer codeOrder;
    private Long exampleId;
}
