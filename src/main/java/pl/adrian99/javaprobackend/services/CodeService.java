package pl.adrian99.javaprobackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adrian99.javaprobackend.entities.CodeCategory;
import pl.adrian99.javaprobackend.entities.CodeExample;
import pl.adrian99.javaprobackend.repositories.CodeCategoryRepository;
import pl.adrian99.javaprobackend.repositories.CodeExampleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeCategoryRepository codeCategoryRepository;
    private final CodeExampleRepository codeExampleRepository;

    public List<CodeCategory> getCategories() {
        return codeCategoryRepository.findAll();
    }

    public List<CodeExample> getCodeExamples(Long categoryId) {
        var category = codeCategoryRepository.findById(categoryId);
        if (category.isPresent()) {
            var examples = category.get().getCodeExamples();
            examples.sort(Comparator.comparingInt(CodeExample::getExampleOrder));
            return examples;
        } else {
            throw new EntityNotFoundException("Code category with id " + categoryId + " not found");
        }
    }

    public CodeExample getCodeExample(Long codeExampleId) {
        return codeExampleRepository.findById(codeExampleId)
                .orElseThrow(() -> new EntityNotFoundException("Code example with id " + codeExampleId + " not found"));
    }
}
