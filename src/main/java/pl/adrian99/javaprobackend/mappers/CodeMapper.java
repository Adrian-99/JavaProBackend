package pl.adrian99.javaprobackend.mappers;

import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.dtos.CodeCategoryDto;
import pl.adrian99.javaprobackend.dtos.CodeDto;
import pl.adrian99.javaprobackend.dtos.CodeExampleBriefDto;
import pl.adrian99.javaprobackend.dtos.CodeExampleDto;
import pl.adrian99.javaprobackend.entities.Code;
import pl.adrian99.javaprobackend.entities.CodeCategory;
import pl.adrian99.javaprobackend.entities.CodeExample;

import java.util.Comparator;
import java.util.List;

@Component
public class CodeMapper {

    public List<CodeCategoryDto> fromCodeCategoryToDto(List<CodeCategory> categories) {
        return categories.stream().map(this::fromCodeCategoryToDto).toList();
    }

    public CodeCategoryDto fromCodeCategoryToDto(CodeCategory category) {
        return new CodeCategoryDto(category.getId(), category.getName());
    }

    public List<CodeExampleBriefDto> fromCodeExampleToBriefDto(List<CodeExample> codeExamples) {
        return codeExamples.stream().map(this::fromCodeExampleToBriefDto).toList();
    }

    public CodeExampleBriefDto fromCodeExampleToBriefDto(CodeExample codeExample) {
        return new CodeExampleBriefDto(codeExample.getId(), codeExample.getName());
    }

    public CodeExampleDto fromCodeExampleToDto(CodeExample codeExample) {
        var codes = codeExample.getCodes();
        codes.sort(Comparator.comparingInt(Code::getCodeOrder));
        return new CodeExampleDto(codeExample.getName(), codeExample.getContext(), fromCodeToDto(codes));
    }

    public List<CodeDto> fromCodeToDto(List<Code> codes) {
        return codes.stream().map(this::fromCodeToDto).toList();
    }

    public CodeDto fromCodeToDto(Code code) {
        return new CodeDto(code.getName(), code.getCode());
    }
}
