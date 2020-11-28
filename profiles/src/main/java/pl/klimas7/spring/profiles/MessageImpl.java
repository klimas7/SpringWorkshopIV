package pl.klimas7.spring.profiles;

import lombok.extern.java.Log;

@Log
public class MessageImpl implements Message {
    private final String message;

    public MessageImpl(String message) {
        this.message = message;
    }


    @Override
    public void sendMessage() {
        log.info(message);
    }
}
