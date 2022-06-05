package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adrian99.javaprobackend.dtos.CodeCategoryDto;
import pl.adrian99.javaprobackend.dtos.CodeExampleBriefDto;
import pl.adrian99.javaprobackend.dtos.CodeExampleDto;
import pl.adrian99.javaprobackend.mappers.CodeMapper;
import pl.adrian99.javaprobackend.services.CodeService;

import java.util.List;

@RestController
@RequestMapping("public/codes")
@RequiredArgsConstructor
public class CodePublicController {

    private final CodeService codeService;
    private final CodeMapper codeMapper;

    @GetMapping("categories")
    public List<CodeCategoryDto> getCategories() {
        var categories = codeService.getCategories();
        return codeMapper.fromCodeCategoryToDto(categories);
    }

    @GetMapping("examples/{categoryId}")
    public List<CodeExampleBriefDto> getCodeExamples(@PathVariable Long categoryId) {
        var codeExamples = codeService.getCodeExamples(categoryId);
        return codeMapper.fromCodeExampleToBriefDto(codeExamples);
    }

    @GetMapping("{codeExampleId}")
    public CodeExampleDto getCodeExample(@PathVariable Long codeExampleId) {
        var codeExample = codeService.getCodeExample(codeExampleId);
        return codeMapper.fromCodeExampleToDto(codeExample);
    }
}
