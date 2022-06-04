package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.adrian99.javaprobackend.dtos.SlideCategoryDto;
import pl.adrian99.javaprobackend.dtos.SlideIdsDto;
import pl.adrian99.javaprobackend.mappers.SlideMapper;
import pl.adrian99.javaprobackend.services.SlideService;

import java.util.List;

@RestController
@RequestMapping("public/slides")
@RequiredArgsConstructor
public class SlidePublicController {

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
}
