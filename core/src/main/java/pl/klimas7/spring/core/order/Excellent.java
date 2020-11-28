package pl.klimas7.spring.core.order;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Excellent implements Rating {
    @Override
    public int getRating() {
        return 1;
    }
}
