package pl.klimas7.spring.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class TestProperty {
    private final String property = "testProperty";

    public String getProperty() {
        return property;
    }
}
