package pl.adrian99.javaprobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.adrian99.javaprobackend.entities.WebTool;

public interface WebToolRepository extends JpaRepository<WebTool, Long> {
}
