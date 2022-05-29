package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.SlideCategory;

public interface SlideCategoryRepository extends JpaRepository<SlideCategory, Long> {
}
