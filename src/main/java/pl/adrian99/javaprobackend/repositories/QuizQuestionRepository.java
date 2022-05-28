package pl.adrian99.javaprobackend.repositories;

import pl.adrian99.javaprobackend.entities.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
}
