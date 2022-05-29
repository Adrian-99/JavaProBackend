package pl.adrian99.javaprobackend.mappers;

import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.dtos.WebToolDto;
import pl.adrian99.javaprobackend.entities.WebTool;

import java.util.List;

@Component
public class WebToolMapper {

    public List<WebToolDto> fromWebToolToDto(List<WebTool> webTools) {
        return webTools.stream().map(this::fromWebToolToDto).toList();
    }

    public WebToolDto fromWebToolToDto(WebTool webTool) {
        return new WebToolDto(webTool.getName(), webTool.getUrl());
    }
}
