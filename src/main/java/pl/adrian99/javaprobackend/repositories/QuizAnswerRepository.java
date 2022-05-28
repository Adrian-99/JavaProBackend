package pl.adrian99.javaprobackend.repositories;

import pl.adrian99.javaprobackend.entities.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Long> {
}
