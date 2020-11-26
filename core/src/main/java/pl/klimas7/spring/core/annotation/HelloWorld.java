package pl.klimas7.spring.core.annotation;

import lombok.extern.java.Log;

@Log
public class HelloWorld {
    private String message;
    private String message2;

    public HelloWorld() {
        log.info("In constructor");
    }

    public HelloWorld(String message, String message2) {
        this.message = message;
        this.message2 = message2;
        log.info("In constructor: " + message + " " + message2);
    }

    public void setMessage(String message) {
        this.message = message;
        log.info("In setter message: " + message);
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
        log.info("In setter message2: " + message2);
    }

    public void print() {
        log.info("Your message: " + message + " " + message2);
    }
}
