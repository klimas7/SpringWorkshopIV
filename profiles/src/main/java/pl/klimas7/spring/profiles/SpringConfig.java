package pl.klimas7.spring.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Message messageTest() {
        return new MessageImpl("SimpleBeanInTest");
    }

    @Bean
    public Message message() {
        return new MessageImpl("SimpleBean");
    }
}
