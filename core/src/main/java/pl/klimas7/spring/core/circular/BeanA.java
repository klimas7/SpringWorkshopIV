package pl.klimas7.spring.core.circular;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class BeanA {
    private static final String message = "BeanA";
    private final BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
        this.beanB.printMessage();
    }

    public void printMessage() {
        log.info(message);
    }
}
