package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.CodeCategory;

public interface CodeCategoryRepository extends JpaRepository<CodeCategory, Long> {
}
