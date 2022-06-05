package pl.adrian99.javaprobackend.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.adrian99.javaprobackend.dtos.admin.CodeCategoryInfoDto;
import pl.adrian99.javaprobackend.dtos.admin.CodeExampleInfoDto;
import pl.adrian99.javaprobackend.dtos.admin.CodeInfoDto;
import pl.adrian99.javaprobackend.entities.Code;
import pl.adrian99.javaprobackend.entities.CodeCategory;
import pl.adrian99.javaprobackend.entities.CodeExample;
import pl.adrian99.javaprobackend.repositories.CodeCategoryRepository;
import pl.adrian99.javaprobackend.repositories.CodeExampleRepository;
import pl.adrian99.javaprobackend.repositories.CodeRepository;
import pl.adrian99.javaprobackend.utils.AdminUtils;

import java.util.List;

@RestController
@RequestMapping("admin/codes")
@RequiredArgsConstructor
public class CodeAdminController {

    private final CodeCategoryRepository codeCategoryRepository;
    private final CodeExampleRepository codeExampleRepository;
    private final CodeRepository codeRepository;

    @GetMapping("categories")
    public List<CodeCategory> getCategories() {
        return codeCategoryRepository.findAll();
    }

    @GetMapping("categories/{categoryId}")
    public CodeCategory getCategory(@PathVariable Long categoryId) {
        return AdminUtils.getEntityOrThrow(CodeCategory.class, codeCategoryRepository, categoryId);
    }

    @PostMapping("categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CodeCategory createCategory(@RequestBody CodeCategoryInfoDto codeCategoryInfoDto) {
        var category = new CodeCategory();
        category.setName(codeCategoryInfoDto.getName());
        codeCategoryRepository.saveAndFlush(category);
        return category;
    }

    @PutMapping("categories/{categoryId}")
    public CodeCategory updateCategory(@PathVariable Long categoryId,
                                       @RequestBody CodeCategoryInfoDto codeCategoryInfoDto) {
        var category = AdminUtils.getEntityOrThrow(CodeCategory.class, codeCategoryRepository, categoryId);
        category.setName(codeCategoryInfoDto.getName());
        return category;
    }

    @DeleteMapping("categories/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {
        var category = AdminUtils.getEntityOrThrow(CodeCategory.class, codeCategoryRepository, categoryId);
        codeCategoryRepository.delete(category);
    }

    @GetMapping("examples")
    public List<CodeExample> getExamples() {
        return codeExampleRepository.findAll();
    }

    @GetMapping("examples/{exampleId}")
    public CodeExample getExample(@PathVariable Long exampleId) {
        return AdminUtils.getEntityOrThrow(CodeExample.class, codeExampleRepository, exampleId);
    }

    @PostMapping("examples")
    @ResponseStatus(HttpStatus.CREATED)
    public CodeExample createExample(@RequestBody CodeExampleInfoDto codeExampleInfoDto) {
        var category = AdminUtils.getEntityOrThrow(
                CodeCategory.class,
                codeCategoryRepository,
                codeExampleInfoDto.getCategoryId()
        );
        var example = new CodeExample();
        example.setName(codeExampleInfoDto.getName());
        example.setContext(codeExampleInfoDto.getContext());
        example.setExampleOrder(codeExampleInfoDto.getExampleOrder());
        example.setCategory(category);
        codeExampleRepository.saveAndFlush(example);
        return example;
    }

    @PutMapping("examples/{exampleId}")
    public CodeExample updateExample(@PathVariable Long exampleId, @RequestBody CodeExampleInfoDto codeExampleInfoDto) {
        var example = AdminUtils.getEntityOrThrow(CodeExample.class, codeExampleRepository, exampleId);
        var category = AdminUtils.getEntityOrThrow(
                CodeCategory.class,
                codeCategoryRepository,
                codeExampleInfoDto.getCategoryId()
        );
        example.setName(codeExampleInfoDto.getName());
        example.setContext(codeExampleInfoDto.getContext());
        example.setExampleOrder(codeExampleInfoDto.getExampleOrder());
        example.setCategory(category);
        codeExampleRepository.saveAndFlush(example);
        return example;
    }

    @DeleteMapping("examples/{exampleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExample(@PathVariable Long exampleId) {
        var example = AdminUtils.getEntityOrThrow(CodeExample.class, codeExampleRepository, exampleId);
        codeExampleRepository.delete(example);
    }

    @GetMapping
    public List<Code> getCodes() {
        return codeRepository.findAll();
    }

    @GetMapping("{codeId}")
    public Code getCode(@PathVariable Long codeId) {
        return AdminUtils.getEntityOrThrow(Code.class, codeRepository, codeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Code createCode(@RequestBody CodeInfoDto codeInfoDto) {
        var example = AdminUtils.getEntityOrThrow(
                CodeExample.class,
                codeExampleRepository,
                codeInfoDto.getExampleId()
        );
        var code = new Code();
        code.setName(codeInfoDto.getName());
        code.setCode(codeInfoDto.getCode());
        code.setCodeOrder(codeInfoDto.getCodeOrder());
        code.setCodeExample(example);
        codeRepository.saveAndFlush(code);
        return code;
    }

    @PutMapping("{codeId}")
    public Code updateCode(@PathVariable Long codeId, @RequestBody CodeInfoDto codeInfoDto) {
        var code = AdminUtils.getEntityOrThrow(Code.class, codeRepository, codeId);
        var example = AdminUtils.getEntityOrThrow(
                CodeExample.class,
                codeExampleRepository,
                codeInfoDto.getExampleId()
        );
        code.setName(codeInfoDto.getName());
        code.setCode(codeInfoDto.getCode());
        code.setCodeOrder(codeInfoDto.getCodeOrder());
        code.setCodeExample(example);
        codeRepository.saveAndFlush(code);
        return code;
    }

    @DeleteMapping("{codeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCode(@PathVariable Long codeId) {
        var code = AdminUtils.getEntityOrThrow(Code.class, codeRepository, codeId);
        codeRepository.delete(code);
    }
}
