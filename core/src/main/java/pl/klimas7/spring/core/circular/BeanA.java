package pl.klimas7.spring.core.circular;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    private final BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }
}
