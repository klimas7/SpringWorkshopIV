package pl.klimas7.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IkeaShop implements Shop {
    @Override
    public void buy() {
        log.info("Kupuję piękną komode");
    }

    @Override
    public void addToBasket(String name) {
        log.info("Add to basket: " + name);
    }
}
