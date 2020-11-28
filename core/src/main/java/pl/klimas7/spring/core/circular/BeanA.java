package pl.klimas7.spring.core.circular;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log
@Component
@Getter
public class BeanA {
    private final String message = "BeanA";
    private final BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }

    public String getOtherMessage() {
        return this.beanB.getMessage();
    }

    public void printMessage() {
        log.info(message);
    }
}
