package pl.klimas7.spring.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static pl.klimas7.spring.jms.QueueName.*;

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

    @JmsListener(destination = TOPIC, containerFactory = "myTopicFactory", concurrency = "2-4")
    public void receiveTopicMessage(@Payload String topic,
                                    @Headers MessageHeaders headers) throws InterruptedException {

        log.info("received Topic <" + topic + ">");
        logHeaders(headers);
        log.info("slepp ...");
        Thread.sleep(10000);
        Thread.sleep(10000);
    }

    private void logHeaders(MessageHeaders headers) {
        log.info("---------------------------------------------------------------");
        headers.forEach((key, value) -> log.info("Header: " + key + " : " + value));
    }
}
