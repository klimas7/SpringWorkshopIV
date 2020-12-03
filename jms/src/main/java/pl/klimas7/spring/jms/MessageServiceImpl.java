package pl.klimas7.spring.jms;

import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
    @Override
    public void sendMessage(String message) {

    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void sendMessageInfo(MessageInfo messageInfo) {

    }

    @Override
    public MessageInfo getMessageInfo() {
        return null;
    }
}
