package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.entities.QuizQuestion;
import pl.adrian99.javaprobackend.services.QuizService;

import java.io.IOException;

@RestController
@RequestMapping("admin/quiz")
@RequiredArgsConstructor
public class QuizAdminController {

    private final QuizService quizService;

    @PostMapping("questions/{categoryId}")
    public QuizQuestion addQuestion(@PathVariable Long categoryId,
                                    @RequestParam String question,
                                    @RequestParam(required = false) MultipartFile image) throws IOException {
        return quizService.addQuestion(categoryId, question, image);
    }
}
