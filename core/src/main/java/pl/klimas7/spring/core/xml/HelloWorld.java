package pl.klimas7.spring.core.xml;

import lombok.extern.java.Log;

@Log
public class HelloWorld {
    private String message;

    public HelloWorld() {
        log.info("In constructor");
    }

    public HelloWorld(String message) {
        this.message = message;
        log.info("In constructor: " + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        log.info("In setter: " + message);
    }


    public void print() {
        log.info("Your message: " + message);
    }
}
