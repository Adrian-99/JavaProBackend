package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.dtos.SlideCategoryDto;
import pl.adrian99.javaprobackend.dtos.SlideIdsDto;
import pl.adrian99.javaprobackend.mappers.SlideMapper;
import pl.adrian99.javaprobackend.services.SlideService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("slides")
@RequiredArgsConstructor
public class SlideController {

    private final SlideService slideService;
    private final SlideMapper slideMapper;

    @GetMapping("categories")
    public List<SlideCategoryDto> getCategories() {
        var categories = slideService.getCategories();
        return slideMapper.fromSlideCategoryToDto(categories);
    }

    @GetMapping("ids/{categoryId}")
    public SlideIdsDto getSlideIds(@PathVariable Long categoryId) {
        var slides = slideService.getSlides(categoryId);
        return slideMapper.fromSlidesToSlideIdsDto(slides);
    }

    @GetMapping("{slideId}")
    public byte[] getSlideData(@PathVariable Long slideId) {
        var slide = slideService.getSlide(slideId);
        return slide.getSlideData();
    }

    @PostMapping("{categoryId}/{slideOrder}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSlide(@PathVariable Long categoryId,
                         @PathVariable Integer slideOrder,
                         @RequestParam MultipartFile image) throws IOException {
        slideService.addSlide(categoryId, slideOrder, image);
    }
}
