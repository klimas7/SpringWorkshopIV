package pl.klimas7.spring.core.circular;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log
@Getter
@Component
public class BeanB {
    private final String message = "BeanB";
    private final BeanA beanA;

    public BeanB(@Lazy BeanA beanA) {
        this.beanA = beanA;
    }

    public String getOtherMessage() {
        return this.beanA.getMessage();
    }

    public void printMessage() {
        log.info(message);
    }
}
