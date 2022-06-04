package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.entities.Slide;
import pl.adrian99.javaprobackend.services.SlideService;

import java.io.IOException;

@RestController
@RequestMapping("admin/slides")
@RequiredArgsConstructor
public class SlideAdminController {

    private final SlideService slideService;

    @PostMapping("{categoryId}/{slideOrder}")
    @ResponseStatus(HttpStatus.CREATED)
    public Slide addSlide(@PathVariable Long categoryId,
                          @PathVariable Integer slideOrder,
                          @RequestParam MultipartFile image) throws IOException {
        return slideService.addSlide(categoryId, slideOrder, image);
    }
}
