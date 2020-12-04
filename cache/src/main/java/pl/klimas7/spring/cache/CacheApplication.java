package pl.klimas7.spring.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class);
    }
}

/*
GET http://localhost:8080/api/cache/John/55

 */
