package pl.klimas7.spring.jms;

public interface MessageService {
    void sendMessage(String message);
    String getMessage();
    void sendMessageInfo(MessageInfo messageInfo);
    MessageInfo getMessageInfo();
    void sendTopic(String topic);
}
