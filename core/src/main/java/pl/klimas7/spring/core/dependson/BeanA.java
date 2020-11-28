package pl.klimas7.spring.core.dependson;

import lombok.extern.java.Log;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Log
@Component
@DependsOn("beanB")
public class BeanA {
    public BeanA() {
        log.info("BeanA");
    }
}
