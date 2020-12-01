package pl.klimas7.spring.jmx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private final MessageManageOperation messageManageOperation;
    private final SmartMessage smartMessage;
    private final MessageNotifier messageNotifier;

    public MessageRestController(MessageManageOperation messageManageOperation,
                                 SmartMessage smartMessage,
                                 MessageNotifier messageNotifier) {
        this.messageManageOperation = messageManageOperation;
        this.smartMessage = smartMessage;
        this.messageNotifier = messageNotifier;
    }

    @GetMapping("/message")
    public String message() {
        messageNotifier.sendNotification();
        return messageManageOperation.getMessage();
    }

    @GetMapping("/message/smart")
    public String smartMessage() {
        return smartMessage.getMessage();
    }
}
