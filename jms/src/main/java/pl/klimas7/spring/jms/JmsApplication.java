package pl.klimas7.spring.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JmsApplication.class);
    }
}
/*
https://youtu.be/0V9Ua538jMI?t=222
 */
