package pl.klimas7.spring.core.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Bad implements Rating {
    @Override
    public int getRating() {
        return 3;
    }
}
