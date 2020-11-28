package pl.klimas7.spring.core.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Order(1)
public class Excellent implements Rating {
    @Override
    public int getRating() {
        return 1;
    }
}
