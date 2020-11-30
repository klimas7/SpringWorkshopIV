package pl.klimas7.spring.jmx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestController {

    @GetMapping("/message")
    public String message() {
        return "hello Sii People!";
    }
}
