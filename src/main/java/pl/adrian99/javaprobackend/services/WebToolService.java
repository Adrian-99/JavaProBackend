package pl.adrian99.javaprobackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.adrian99.javaprobackend.entities.WebTool;
import pl.adrian99.javaprobackend.repositories.WebToolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebToolService {

    private final WebToolRepository webToolRepository;

    public List<WebTool> getWebTools() {
        return webToolRepository.findAll();
    }
}
