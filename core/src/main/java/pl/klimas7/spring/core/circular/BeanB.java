package pl.klimas7.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanB {
    private final BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }
}
