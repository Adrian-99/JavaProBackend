package pl.adrian99.javaprobackend.initializers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.adrian99.javaprobackend.entities.WebTool;
import pl.adrian99.javaprobackend.repositories.WebToolRepository;

import java.util.List;

@Component
@ConditionalOnProperty(name = "initializers.enabled", havingValue = "true")
@RequiredArgsConstructor
public class WebToolInitializer implements ApplicationRunner {

    private final WebToolRepository webToolRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (webToolRepository.count() == 0) {
            var webTool1 = new WebTool();
            webTool1.setName("JDK 18 API");
            webTool1.setUrl("https://docs.oracle.com/en/java/javase/18/docs/api/index.html");

            var webTool2 = new WebTool();
            webTool2.setName("Android Guide");
            webTool2.setUrl("https://developer.android.com/guide");

            var webTool3 = new WebTool();
            webTool3.setName("JavaFX 18 API");
            webTool3.setUrl("https://openjfx.io/javadoc/18/");

            var webTool4 = new WebTool();
            webTool4.setName("Java EE API");
            webTool4.setUrl("https://www.oracle.com/pl/java/technologies/java-ee-glance.html");

            webToolRepository.saveAllAndFlush(List.of(webTool1, webTool2, webTool3, webTool4));
        }
    }
}
