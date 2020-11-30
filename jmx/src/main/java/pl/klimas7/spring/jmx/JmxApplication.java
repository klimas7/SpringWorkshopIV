package pl.klimas7.spring.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableMBeanExport
public class JmxApplication {
    public static void main(String[] args) {
        SpringApplication.run(JmxApplication.class);
    }
}
