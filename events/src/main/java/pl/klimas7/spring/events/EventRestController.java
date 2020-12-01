package pl.klimas7.spring.events;

import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/processMessage/{message}")
    public ResponseEntity<Void> processMessage(@PathVariable String message) {
        log.info("Process message: " + message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
