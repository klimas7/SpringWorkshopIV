package pl.klimas7.spring.core.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld("Sii Power People!!", null);
    }

    @Bean(name = "helloWorldSetter")
    public HelloWorld helloWorld2() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Sii Power People by setter!");
        return helloWorld;
    }
}
