package pl.klimas7.spring.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static pl.klimas7.spring.jms.QueueName.OBJECT;
import static pl.klimas7.spring.jms.QueueName.TEXT;

@Slf4j
@Component
public class QueueReceiver {

    @JmsListener(destination = TEXT, containerFactory = "myFactory")
    public void receiveText(@Payload String text, @Headers MessageHeaders headers) {
        log.info("Text from receiver: " + text);
        logHeaders(headers);
    }

    @JmsListener(destination = OBJECT, containerFactory = "myFactory")
    public void receiveMessage(@Payload MessageInfo messageInfo, @Headers MessageHeaders headers) {
        log.info("Message from receiver: " + messageInfo);
        logHeaders(headers);
    }

    private void logHeaders(MessageHeaders headers) {
        headers.forEach((key, value) -> log.info("Header: " + key + " : " + value));
    }
}
