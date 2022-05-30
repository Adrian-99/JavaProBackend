package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.CodeExample;

public interface CodeExampleRepository extends JpaRepository<CodeExample, Long> {
}
