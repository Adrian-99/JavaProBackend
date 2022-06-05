package pl.adrian99.javaprobackend.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.dtos.admin.SlideCategoryInfoDto;
import pl.adrian99.javaprobackend.entities.Slide;
import pl.adrian99.javaprobackend.entities.SlideCategory;
import pl.adrian99.javaprobackend.repositories.SlideCategoryRepository;
import pl.adrian99.javaprobackend.repositories.SlideRepository;
import pl.adrian99.javaprobackend.utils.AdminUtils;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("admin/slides")
@RequiredArgsConstructor
public class SlideAdminController {

    private final SlideCategoryRepository slideCategoryRepository;
    private final SlideRepository slideRepository;

    @GetMapping("categories")
    public List<SlideCategory> getCategories() {
        return slideCategoryRepository.findAll();
    }

    @GetMapping("categories/{categoryId}")
    public SlideCategory getCategory(@PathVariable Long categoryId) {
        return AdminUtils.getEntityOrThrow(SlideCategory.class, slideCategoryRepository, categoryId);
    }

    @PostMapping("categories")
    @ResponseStatus(HttpStatus.CREATED)
    public SlideCategory createCategory(@RequestBody SlideCategoryInfoDto slideCategoryInfoDto) {
        var category = new SlideCategory();
        category.setName(slideCategoryInfoDto.getName());
        slideCategoryRepository.saveAndFlush(category);
        return category;
    }

    @PutMapping("categories/{categoryId}")
    public SlideCategory updateCategory(@PathVariable Long categoryId,
                                        @RequestBody SlideCategoryInfoDto slideCategoryInfoDto) {
        var category = AdminUtils.getEntityOrThrow(SlideCategory.class, slideCategoryRepository, categoryId);
        category.setName(slideCategoryInfoDto.getName());
        slideCategoryRepository.saveAndFlush(category);
        return category;
    }

    @DeleteMapping("categories/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long categoryId) {
        var category = AdminUtils.getEntityOrThrow(SlideCategory.class, slideCategoryRepository, categoryId);
        slideCategoryRepository.delete(category);
    }

    @GetMapping
    public List<Slide> getSlides() {
        return slideRepository.findAll();
    }

    @GetMapping("{slideId}")
    public Slide getSlide(@PathVariable Long slideId) {
        return AdminUtils.getEntityOrThrow(Slide.class, slideRepository, slideId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Slide addSlide(@RequestParam Long categoryId,
                          @RequestParam Integer slideOrder,
                          @RequestParam MultipartFile image) throws IOException {
        var category = AdminUtils.getEntityOrThrow(SlideCategory.class, slideCategoryRepository, categoryId);
        var slide = new Slide();
        slide.setSlideData(image.getBytes());
        slide.setSlideOrder(slideOrder);
        slide.setCategory(category);
        slideRepository.saveAndFlush(slide);
        return slide;
    }

    @PutMapping("{slideId}")
    public Slide updateSlide(@PathVariable Long slideId,
                             @RequestParam Long categoryId,
                             @RequestParam Integer slideOrder,
                             @RequestParam MultipartFile image) throws IOException {
        var slide = AdminUtils.getEntityOrThrow(Slide.class, slideRepository, slideId);
        var category = AdminUtils.getEntityOrThrow(SlideCategory.class, slideCategoryRepository, categoryId);
        slide.setSlideData(image.getBytes());
        slide.setSlideOrder(slideOrder);
        slide.setCategory(category);
        slideRepository.saveAndFlush(slide);
        return slide;
    }

    @DeleteMapping("{slideId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSlide(@PathVariable Long slideId) {
        var slide = AdminUtils.getEntityOrThrow(Slide.class, slideRepository, slideId);
        slideRepository.delete(slide);
    }
}
