package pl.adrian99.javaprobackend.mappers;

import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.dtos.SlideCategoryDto;
import pl.adrian99.javaprobackend.dtos.SlideIdsDto;
import pl.adrian99.javaprobackend.entities.Slide;
import pl.adrian99.javaprobackend.entities.SlideCategory;

import java.util.List;

@Component
public class SlideMapper {

    public List<SlideCategoryDto> fromSlideCategoryToDto(List<SlideCategory> slideCategories) {
        return slideCategories.stream().map(this::fromSlideCategoryToDto).toList();
    }

    public SlideCategoryDto fromSlideCategoryToDto(SlideCategory slideCategory) {
        return new SlideCategoryDto(slideCategory.getId(), slideCategory.getName());
    }

    public SlideIdsDto fromSlidesToSlideIdsDto(List<Slide> slides) {
        return new SlideIdsDto(slides.stream().map(Slide::getId).toList());
    }
}
