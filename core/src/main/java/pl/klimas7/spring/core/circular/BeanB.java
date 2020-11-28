package pl.klimas7.spring.core.circular;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log
@Component
public class BeanB {
    private static final String message = "BeanB";
    private final BeanA beanA;

    public BeanB(@Lazy BeanA beanA) {
        this.beanA = beanA;
    }

    @PostConstruct
    public void print() {
        this.beanA.printMessage();
    }

    public void printMessage() {
        log.info(message);
    }
}
