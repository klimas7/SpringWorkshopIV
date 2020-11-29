package pl.klimas7.spring.profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan
@PropertySources({
        @PropertySource("classpath:application-test.properties")
        })
public class TestConfig {
}
