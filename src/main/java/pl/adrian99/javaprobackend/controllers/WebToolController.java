package pl.adrian99.javaprobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adrian99.javaprobackend.dtos.WebToolDto;
import pl.adrian99.javaprobackend.mappers.WebToolMapper;
import pl.adrian99.javaprobackend.services.WebToolService;

import java.util.List;

@RestController
@RequestMapping("webtools")
@RequiredArgsConstructor
public class WebToolController {

    private final WebToolService webToolService;
    private final WebToolMapper webToolMapper;

    @GetMapping
    public List<WebToolDto> getWebTools() {
        var webTools = webToolService.getWebTools();
        return webToolMapper.fromWebToolToDto(webTools);
    }
}
