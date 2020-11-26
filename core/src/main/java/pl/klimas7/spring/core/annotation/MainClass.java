package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@Log
public class MainClass {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("pl.klimas7.spring.core.annotation");
        log.info("Bean definition count: " + context.getBeanDefinitionCount());
        Arrays.asList(context.getBeanDefinitionNames()).forEach(log::info);
    }
}
