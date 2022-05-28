package pl.adrian99.javaprobackend.repositories;

import pl.adrian99.javaprobackend.entities.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizCategoryRepository extends JpaRepository<QuizCategory, Long> {
}
