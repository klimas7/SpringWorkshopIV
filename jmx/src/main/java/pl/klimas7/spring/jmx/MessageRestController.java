package pl.klimas7.spring.jmx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private MessageManageOperation messageManageOperation;

    public MessageRestController(MessageManageOperation messageManageOperation) {
        this.messageManageOperation = messageManageOperation;
    }

    @GetMapping("/message")
    public String message() {
        return messageManageOperation.getMessage();
    }
}
