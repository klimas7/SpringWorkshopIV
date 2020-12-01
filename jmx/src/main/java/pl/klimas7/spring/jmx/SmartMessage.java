package pl.klimas7.spring.jmx;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "jmxApplication:name=SmartMessage")
public class SmartMessage {
    private static final String DEFAULT_MESSAGE = "Hello Sii People (Smart)";
    private String message = DEFAULT_MESSAGE;
    private String privateMessage = DEFAULT_MESSAGE;

    @ManagedOperation
    public void setMessage(String message) {
        this.message = message;
    }

    @ManagedOperation
    public String getMessage() {
        return message;
    }

    public String getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(String privateMessage) {
        this.privateMessage = privateMessage;
    }
}
