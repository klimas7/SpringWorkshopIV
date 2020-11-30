package pl.klimas7.spring.aop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExecutionsShopping {
    private Shop shop;

    public ExecutionsShopping(Shop shop) {
        this.shop = shop;
    }

    @PostConstruct
    public void shopping() {
        shop.buy();

        shop.addToBasket("Krzesło");
        shop.addToBasket("Krzesło");
        shop.addToBasket("Krzesło");
        shop.addToBasket("Krzesło");
        shop.addToBasket("Stół");
        shop.addToBasket("Kubek");
        shop.addToBasket("Kubek ");
    }
}
