package pl.klimas7.spring.core.order;

import org.springframework.stereotype.Component;

@Component
public class Bad implements Rating {
    @Override
    public int getRating() {
        return 3;
    }
}
