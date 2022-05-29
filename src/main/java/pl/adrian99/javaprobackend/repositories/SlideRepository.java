package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.Slide;

public interface SlideRepository extends JpaRepository<Slide, Long> {
}
