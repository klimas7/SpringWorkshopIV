package pl.klimas7.spring.jms;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class MessageServiceImpl implements MessageService {

    private static final String QUEUE_PLAIN_TEXT = "message.queue.plainText";
    private static final String QUEUE_OBJECT = "message.queue.object";

    private final JmsOperations jmsOperations;

    public MessageServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendMessage(String message) {
        jmsOperations.send(QUEUE_PLAIN_TEXT, session -> session.createTextMessage(message));
    }

    @SneakyThrows
    @Override
    public String getMessage() {
        Message receive = jmsOperations.receive(QUEUE_PLAIN_TEXT);
        return  ((TextMessage)receive).getText();
    }

    @Override
    public void sendMessageInfo(MessageInfo messageInfo) {
        jmsOperations.convertAndSend(QUEUE_OBJECT, messageInfo);
    }

    @Override
    public MessageInfo getMessageInfo() {
        return (MessageInfo) jmsOperations.receiveAndConvert(QUEUE_OBJECT);
    }
}
