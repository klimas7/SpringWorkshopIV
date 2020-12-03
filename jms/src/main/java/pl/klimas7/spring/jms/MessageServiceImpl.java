package pl.klimas7.spring.jms;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

import static pl.klimas7.spring.jms.QueueName.*;

@Slf4j
@Component
public class MessageServiceImpl implements MessageService {
    private final JmsOperations jmsOperations;

    public MessageServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendMessage(String message) {
        jmsOperations.convertAndSend(TEXT, message);
    }

    @SneakyThrows
    @Override
    public String getMessage() {
        Message receive = jmsOperations.receive(TEXT);
        return  ((TextMessage)receive).getText();
    }

    @Override
    public void sendMessageInfo(MessageInfo messageInfo) {
        jmsOperations.convertAndSend(OBJECT, messageInfo);
        //jmsOperations.convertAndSend(messageInfo);
    }

    @Override
    public MessageInfo getMessageInfo() {
        return (MessageInfo) jmsOperations.receiveAndConvert(OBJECT);
        //return (MessageInfo) jmsOperations.receiveAndConvert();
    }

    @Override
    public void sendTopic(String topic) {
        jmsOperations.convertAndSend(new ActiveMQTopic(TOPIC), topic);
    }
}
