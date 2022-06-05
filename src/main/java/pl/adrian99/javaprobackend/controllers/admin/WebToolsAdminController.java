package pl.adrian99.javaprobackend.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.adrian99.javaprobackend.dtos.admin.WebToolInfoDto;
import pl.adrian99.javaprobackend.entities.WebTool;
import pl.adrian99.javaprobackend.repositories.WebToolRepository;
import pl.adrian99.javaprobackend.utils.AdminUtils;

import java.util.List;

@RestController
@RequestMapping("admin/webtools")
@RequiredArgsConstructor
public class WebToolsAdminController {

    private final WebToolRepository webToolRepository;

    @GetMapping
    public List<WebTool> getWebTools() {
        return webToolRepository.findAll();
    }

    @GetMapping("{webToolId}")
    public WebTool getWebTool(@PathVariable Long webToolId) {
        return AdminUtils.getEntityOrThrow(WebTool.class, webToolRepository, webToolId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WebTool createWebTool(@RequestBody WebToolInfoDto webToolInfoDto) {
        var webTool = new WebTool();
        webTool.setName(webToolInfoDto.getName());
        webTool.setUrl(webToolInfoDto.getUrl());
        webToolRepository.saveAndFlush(webTool);
        return webTool;
    }

    @PutMapping("{webToolId}")
    public WebTool updateWebTool(@PathVariable Long webToolId, @RequestBody WebToolInfoDto webToolInfoDto) {
        var webTool = AdminUtils.getEntityOrThrow(WebTool.class, webToolRepository, webToolId);
        webTool.setName(webToolInfoDto.getName());
        webTool.setUrl(webToolInfoDto.getUrl());
        webToolRepository.saveAndFlush(webTool);
        return webTool;
    }

    @DeleteMapping("{webToolId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWebTool(@PathVariable Long webToolId) {
        var webTool = AdminUtils.getEntityOrThrow(WebTool.class, webToolRepository, webToolId);
        webToolRepository.delete(webTool);
    }
}
