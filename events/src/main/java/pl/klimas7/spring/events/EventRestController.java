package pl.klimas7.spring.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
public class EventRestController {
    private ApplicationEventPublisher applicationEventPublisher;

    public EventRestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @PostMapping("/processMessage/{message}")
    public ResponseEntity<Void> processMessage(@PathVariable String message) {
        log.info("Process message: " + message);

        applicationEventPublisher.publishEvent(new MessageEvent(this, message));
        log.info("After publish event");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
