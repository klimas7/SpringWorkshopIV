package pl.klimas7.spring.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsApplications {
    public static void main(String[] args) {
        SpringApplication.run(EventsApplications.class);
    }

    /*
    Events hints!

    - yourEvent extend ApplicationEvent
    - publisher inject ApplicationEventPublisher
    - listener implement ApplicationListener interface

     */
}
