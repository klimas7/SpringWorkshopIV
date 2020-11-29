package pl.klimas7.spring.profiles;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

//-Dspring.profiles.active=test
@Log
public class MainClass {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AppConfiguration.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(log::info);

        log.info("ActiveProfiles: " + Arrays.toString(applicationContext.getEnvironment().getActiveProfiles()));
        log.info("DefaultProfiles: " + Arrays.toString(applicationContext.getEnvironment().getDefaultProfiles()));

        log.info("----------------");
        Message message = applicationContext.getBean("message", Message.class);
        message.sendMessage();
    }
}
