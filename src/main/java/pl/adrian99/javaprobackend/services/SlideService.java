package pl.adrian99.javaprobackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.adrian99.javaprobackend.entities.Slide;
import pl.adrian99.javaprobackend.entities.SlideCategory;
import pl.adrian99.javaprobackend.repositories.SlideCategoryRepository;
import pl.adrian99.javaprobackend.repositories.SlideRepository;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlideService {

    private final SlideCategoryRepository slideCategoryRepository;
    private final SlideRepository slideRepository;

    public List<SlideCategory> getCategories() {
        return slideCategoryRepository.findAll();
    }

    public List<Slide> getSlides(Long categoryId) {

        var category = slideCategoryRepository.findById(categoryId);
        if (category.isPresent()) {
            var slides = category.get().getSlides();
            slides.sort(Comparator.comparingInt(Slide::getSlideOrder));
            return slides;
        } else {
            throw new EntityNotFoundException("Slide category with id " + categoryId + " not found");
        }
    }

    public Slide getSlide(Long slideId) {
        return slideRepository.findById(slideId)
                .orElseThrow(() -> new EntityNotFoundException("Slide with id " + slideId + " not found"));
    }

    public void addSlide(Long categoryId, Integer slideOrder, MultipartFile image) throws IOException {
        var category = slideCategoryRepository.findById(categoryId);
        if (category.isPresent()) {
            var slide = new Slide();
            slide.setSlideData(image.getBytes());
            slide.setSlideOrder(slideOrder);
            slide.setCategory(category.get());
            slideRepository.saveAndFlush(slide);
        } else {
            throw new EntityNotFoundException("Slide category with id " + categoryId + " not found");
        }
    }
}
