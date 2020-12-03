package pl.klimas7.spring.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private final MessageService messageService;

    public ApiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/text")
    public ResponseEntity<Void> sendText(@RequestParam("text") String text) {
        log.info("Send text: " + text);
        messageService.sendMessage(text);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/message")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageInfo messageInfo) {
        log.info("Send message info: " + messageInfo);
        messageService.sendMessageInfo(messageInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/topic")
    public ResponseEntity<Void>  sendTopic(@RequestParam("topic") String topic) {
        log.info("Send topic info: " + topic);
        messageService.sendTopic(topic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/text")
    public String getText() {
        log.info("Get text");
        return messageService.getMessage();
    }

    @GetMapping("/message")
    public MessageInfo getMessage() {
        log.info("Get message info");
        return messageService.getMessageInfo();
    }
}

/*
GET http://localhost:8080/api/text

###
GET http://localhost:8080/api/message

###
POST http://localhost:8080/api/text?text=SiiPowerPeople

###
POST http://localhost:8080/api/message
Content-Type: application/json

{"message" : "Hello Sii People", "count": 1}
 */
