package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.Code;

public interface CodeRepository extends JpaRepository<Code, Long> {
}
