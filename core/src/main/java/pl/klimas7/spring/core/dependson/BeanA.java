package pl.klimas7.spring.core.dependson;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public class BeanA {
    public BeanA() {
        log.info("BeanA");
    }
}
