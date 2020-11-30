package pl.klimas7.spring.jmx;

import org.springframework.stereotype.Component;

@Component
public class MessageManageOperationImpl implements MessageManageOperation {
    private static final String DEFAULT_MESSAGE = "Hello Sii People";
    private String message = DEFAULT_MESSAGE;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
