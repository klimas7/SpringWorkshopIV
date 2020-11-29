package pl.klimas7.spring.properties;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.Delimiter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
//@PropertySource("classpath:klimas7_2.properties")
//@PropertySource("classpath:klimas7.properties")

@PropertySources({
        @PropertySource("classpath:klimas7.properties"),
        @PropertySource("classpath:klimas7_2.properties")
})
public class PropertiesComponent {
    private final Environment env;

    @Value("${klimas7.spring.p1}")
    private String p1;

    @Value("${klimas7.spring.p2:test.p2}")
    private String p2;
    //PropertyPlaceholderHelper.parseStringValue:152
    // -> PropertySourcesPropertyResolver

    @Value("${klimas7.spring.p3}")
    private List<String> p3;
    //DelimitedStringToCollectionConverter

    @Delimiter("@")
    @Value("${klimas7.spring.p3a}")
    private List<String> p3a;

    @Value("#{'${klimas7.spring.p3b}'.split('#')}") //SpEL
    private List<String> p3b;

    @Value("${klimas7.spring.p4}")
    private String p4;

    @Value("${klimas7.spring.p4a}")
    private String p4a;

    @Value("${klimas7.spring.null:#{null}}")
    private String pNull;

    @Value("#{${klimas7.spring.p5} + 10}")
    private String p5;

    @Value("#{systemProperties['user.name']}")
    private String userName;

    //    @Value("#{testProperty['property']}")
    @Value("#{testProperty.property}")
    private String propertyFromClass;
    //StandardBeanExpressionResolver -> SpelExpression -> ... -> Indexer -> ReflectivePropertyAccessor:700

    @Value("#{propertyGenerator.generate('${klimas7.spring.p6}')}")
    private Map<String, String> p6;

    @Value("#{${klimas7.spring.p6a}}")
    private Map<String, String> p6a;

    public PropertiesComponent(Environment env) {
        this.env = env;
    }

    @PostConstruct
    private void printProperties() {
        log.info("userHome: " + env.getProperty("user.home"));
        log.info("active profile: " + Arrays.asList(env.getActiveProfiles()));
        log.info("default profile: " + Arrays.asList(env.getDefaultProfiles()));

        Arrays.stream(this.getClass().getDeclaredFields())
                .forEach(this::printFieldValue);
    }

    @SneakyThrows
    private void printFieldValue(Field field) {
        log.info(field.getName() + ": " + field.get(this));
    }
}
